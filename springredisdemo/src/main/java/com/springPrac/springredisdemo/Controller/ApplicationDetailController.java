package com.springPrac.springredisdemo.Controller;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Service.ApplicationDetailsevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/applicationdetail")
public class ApplicationDetailController {

	@Autowired
	ApplicationDetailsevice applicationDetailservice;

	@PostMapping(path = "/createapplication", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity createApplication(@Valid @RequestBody ApplicationDetail applicationDetail) {
		applicationDetailservice.createNewApplication(applicationDetail);
		return ResponseEntity.status(HttpStatus.CREATED).location(ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/" + applicationDetail.getApplication_id().toString()).build().toUri()).build();

	}

	@Cacheable(value="application",key="#result.application_id")
	@GetMapping(path = "/getapplication/{applicantId}")
	public ResponseEntity<ApplicationDetail> getApplicationdetailByApplicantId(@PathVariable Long applicantId) {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
