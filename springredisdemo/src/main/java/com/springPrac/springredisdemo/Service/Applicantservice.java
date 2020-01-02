package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.AppDTO.ApplicantInfoDTO;
import com.springPrac.springredisdemo.Model.Applicant;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.QApplicant;
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
	KafkaTemplate<Long, Object> kafkaTemplate;
	@Autowired
	ApplicationDetailRepository applicationDetailRepository;

	public void deleteApplicationByApplicantId(Long applicantId) {
		applicantRepository.deleteById(applicantId);
	}

	@Scheduled(cron = "0/30 * * * * MON-FRI")
	public void dispatchapplicationToverificationService() {
		List<ApplicantInfoDTO> applicants = new ArrayList<ApplicantInfoDTO>();
		QApplicationDetail qApplicationDetail = QApplicationDetail.applicationDetail;
		List<ApplicationDetail> applicationDetailList = (List<ApplicationDetail>) applicationDetailRepository
				.findAll(qApplicationDetail.status.equalsIgnoreCase("in progress"));
		applicationDetailList.forEach(e -> {
			Applicant applicant = applicantRepository.findById(e.getApplicant().getApplicant_id()).get();
			ApplicantInfoDTO applicantInfoDTO = new ApplicantInfoDTO();
			applicantInfoDTO.setAddress(applicant.getAddress().getAddressList());
			applicantInfoDTO.setAge(applicant.getAge());
			applicantInfoDTO.setName(applicant.getName());
			applicantInfoDTO.setIdentification_num(applicant.getIdentification_num());
			applicants.add(applicantInfoDTO);

		});
		applicants.forEach(e -> {
			ListenableFuture<SendResult<Long, Object>> future = kafkaTemplate.send("application_verification", e);
			future.addCallback(new ListenableFutureCallback<SendResult<Long, Object>>() {

				@Override
				public void onSuccess(SendResult<Long, Object> result) {
					ApplicationDetail app = applicationDetailRepository
							.findOne(QApplicationDetail.applicationDetail.applicant.applicant_id.eq(applicantRepository
									.findOne(QApplicant.applicant.identification_num.eq(e.getIdentification_num()))
									.get().getApplicant_id()))
							.get();
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
