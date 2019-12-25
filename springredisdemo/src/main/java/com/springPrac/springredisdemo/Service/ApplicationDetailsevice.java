package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.Model.Adress;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.Location;
import com.springPrac.springredisdemo.Repository.AddressRepository;
import com.springPrac.springredisdemo.Repository.ApplicantRepository;
import com.springPrac.springredisdemo.Repository.ApplicationDetailRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationDetailsevice {
	@Autowired
	ApplicationDetailRepository applicationDetailRepository;
	@Autowired
	AddressRepository addressrepo;

	public void createNewApplication(ApplicationDetail applicationDetail) {
		Location loc = applicationDetail.getApplicant().getAddress();
		List<Adress> adl = new ArrayList<Adress>();
		loc.getAddressList().forEach(add -> {
			adl.add(add);
			add.setLocation(loc);
		});
		loc.setAddressList(adl);
		applicationDetail.getApplicant().setAddress(loc);
		applicationDetailRepository.save(applicationDetail);
	}

	public ApplicationDetail getApplicationByApplicantId(Long applicantId) {
		return applicationDetailRepository.getApplicationByApplicantId(applicantId);
	}

	public void updateApplication(@Valid ApplicationDetail applicationDetail, Long applicantId) {
		ApplicationDetail appdetail=applicationDetailRepository.getApplicationByApplicantId(applicantId);
		applicationDetail.setApplication_id(appdetail.getApplication_id());
		applicationDetailRepository.save(applicationDetail);
	}
	public void deleteApplicationByApplicantId(Long applicantId) {
		Long id=applicationDetailRepository.getApplicationByApplicantId(applicantId).getApplication_id();
		applicationDetailRepository.deleteById(id);
	}

}
