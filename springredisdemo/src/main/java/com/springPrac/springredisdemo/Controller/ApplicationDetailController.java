package com.springPrac.springredisdemo.Controller;

import com.springPrac.springredisdemo.AppException.GenericApplicationDetailsException;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Service.ApplicationDetailsevice;
import com.springPrac.springredisdemo.Service.Applicationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController("ApplicationDetail")
@RequestMapping("/applicationdetail")
public class ApplicationDetailController {

	@Autowired
	ApplicationDetailsevice applicationDetailservice;

	@Autowired
	Applicationservice applicationservice;

	@PostMapping(path = "/createapplication", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity createApplication(@Valid @RequestBody ApplicationDetail applicationDetail) {
		try {
			applicationDetailservice.createNewApplication(applicationDetail);
			return ResponseEntity.status(HttpStatus.CREATED)
					.location(ServletUriComponentsBuilder.fromCurrentRequestUri()
							.path("/" + applicationDetail.getApplication_id().toString()).build().toUri())
					.build();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	// @Cacheable(value="application",key="#applicantId")
	@GetMapping(path = "/getapplication/{applicantId}",produces="application/json")
	@ResponseBody
	public ResponseEntity<ApplicationDetail> getApplicationdetailByApplicantId(@PathVariable Long applicantId)
			throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new GenericApplicationDetailsException();
		}

	}

	@DeleteMapping(path = "/deleteapplication/{applicantId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseEntity<ApplicationDetail> deleteApplicationdetailByApplicantId(@PathVariable Long applicantId)
			throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
						HttpStatus.NOT_FOUND);
			}
			applicationservice.deleteApplicationByApplicantId(applicantId);
			return new ResponseEntity<ApplicationDetail>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			throw new GenericApplicationDetailsException();
		}

	}

	@PutMapping(path = "/updateapplication/{applicantId}",consumes="application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<ApplicationDetail> updateApplicationdetailByApplicantId(
			@Valid @RequestBody ApplicationDetail applicationDetail, @PathVariable Long applicantId) throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
						HttpStatus.NOT_FOUND);
			}
			applicationDetailservice.updateApplication(applicationDetail, applicantId);
			return new ResponseEntity<ApplicationDetail>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
