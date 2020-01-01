package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.Model.Applicant;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.QApplicant;
import com.springPrac.springredisdemo.Model.QApplicationDetail;
import com.springPrac.springredisdemo.Repository.ApplicationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.springPrac.springredisdemo.Repository.ApplicantRepository;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;

@Service
public class Applicantservice {
	
	@Autowired
	ApplicantRepository applicantRepository;
	@Autowired
	KafkaTemplate kafkaTemplate;
	@Autowired
	ApplicationDetailRepository applicationDetailRepository;

	public void deleteApplicationByApplicantId(Long applicantId) {
		applicantRepository.deleteById(applicantId);
	}

	public void dispatchapplicationToverificationService() {
		List<Applicant> applicants=null;
		QApplicationDetail qApplicationDetail=QApplicationDetail.applicationDetail;
		List<ApplicationDetail> applicationDetailList=(List<ApplicationDetail>) applicationDetailRepository.findAll(qApplicationDetail.status.equalsIgnoreCase("in progress"));
		applicationDetailList.forEach(e->{
			applicants.add(applicantRepository.findById(e.getApplicant().getApplicant_id()).get());
		});
		applicants.forEach(e->{
			kafkaTemplate.send("application_verfication",e).addCallback(new ListenableFutureCallback() {
				@Override
				public void onFailure(Throwable throwable) {
					System.out.println("data not sent");
				}

				@Override
				public void onSuccess(Object o) {
					System.out.println("data sent");
				}
			});
		});
	}
}
