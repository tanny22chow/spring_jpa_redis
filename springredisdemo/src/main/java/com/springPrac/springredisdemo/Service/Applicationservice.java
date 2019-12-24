package com.springPrac.springredisdemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springPrac.springredisdemo.Repository.ApplicantRepository;

@Service
public class Applicationservice {
	
	@Autowired
	ApplicantRepository applicantRepository;

	public void deleteApplicationByApplicantId(Long applicantId) {
		applicantRepository.deleteById(applicantId);
	}
	

}
