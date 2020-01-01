package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.Model.Applicant;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.QApplicationDetail;
import com.springPrac.springredisdemo.Repository.ApplicationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.springPrac.springredisdemo.Repository.ApplicantRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class Applicantservice {
	
	@Autowired
	ApplicantRepository applicantRepository;
	@Autowired
	KafkaTemplate<Long,Object> kafkaTemplate;
	@Autowired
	ApplicationDetailRepository applicationDetailRepository;

	public void deleteApplicationByApplicantId(Long applicantId) {
		applicantRepository.deleteById(applicantId);
	}
	
	@Scheduled(cron="0/30 * * * * MON-FRI")
	public void dispatchapplicationToverificationService() {
		List<Applicant> applicants=new ArrayList<Applicant>();
		QApplicationDetail qApplicationDetail=QApplicationDetail.applicationDetail;
		List<ApplicationDetail> applicationDetailList= (List<ApplicationDetail>) applicationDetailRepository.findAll(qApplicationDetail.status.equalsIgnoreCase("in progress"));
		applicationDetailList.forEach(e->{
			applicants.add(applicantRepository.findById(e.getApplicant().getApplicant_id()).get());
		});
		applicants.forEach(e->{
			ListenableFuture<SendResult<Long, Object>> future=kafkaTemplate.send("application_verification",e);
			future.addCallback(new ListenableFutureCallback<SendResult<Long, Object>>() {

				@Override
				public void onSuccess(SendResult<Long, Object> result) {
					ApplicationDetail app=e.getApplicationDetail();
					app.setStatus("pending verification");
					applicationDetailRepository.save(app);
					
				}

				@Override
				public void onFailure(Throwable ex) {
					System.out.println("data not sent");
					
				}
			});
			
			
		});
	}
}
