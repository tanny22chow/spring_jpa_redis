package com.springPrac.springredisdemo.Controller;

import com.springPrac.springredisdemo.AppException.GenericApplicationDetailsException;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Service.ApplicationDetailsevice;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController("ApplicationDetail")
@RequestMapping("/applicationdetail")
public class ApplicationDetailController {

	@Autowired
	ApplicationDetailsevice applicationDetailservice;

	@ApiOperation(value = "creates an aplication based on applicant", consumes = "application/json")
	@PostMapping(path = "/createapplication", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> createApplication(@Valid @RequestBody ApplicationDetail applicationDetail) {
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
	@GetMapping(path = "/getapplication/{applicantId}", produces = "application/json")
	@ApiOperation(value = "retrives aplication based on applicant", produces = "application/json", response = ApplicationDetail.class)
	@ResponseBody
	public ResponseEntity<ApplicationDetail> getApplicationdetailByApplicantId(@PathVariable Long applicantId)
			throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(applicationDetailservice.getApplicationByApplicantId(applicantId),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new GenericApplicationDetailsException();
		}

	}

	@DeleteMapping(path = "/deleteapplication/{applicantId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "delete aplication based on applicant")
	@ResponseBody
	public ResponseEntity<ApplicationDetail> deleteApplicationdetailByApplicantId(@PathVariable Long applicantId)
			throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			applicationDetailservice.deleteApplicationByApplicantId(applicantId);
			return new ResponseEntity<ApplicationDetail>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			throw new GenericApplicationDetailsException();
		}

	}

	@PutMapping(path = "/updateapplication/{applicantId}", consumes = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "updates an aplication based on applicant", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<ApplicationDetail> updateApplicationdetailByApplicantId(
			@Valid @RequestBody ApplicationDetail applicationDetail, @PathVariable Long applicantId) throws Exception {
		try {
			if (applicationDetailservice.getApplicationByApplicantId(applicantId) == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			applicationDetailservice.updateApplication(applicationDetail, applicantId);
			return new ResponseEntity<ApplicationDetail>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(path = "/batch/purge")
	@ApiOperation(value = "cleans up redundant data in completed status")
	public ResponseEntity<Object> triggerApplicationPurgeBatch() {
		applicationDetailservice.applicationDetailPurgeBatch();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping(path = "/getapplication", produces = "application/json")
	@ApiOperation(value = "retrives aplication based on status", produces = "application/json", response = ApplicationDetail.class)
	@ResponseBody
	public ResponseEntity<List<ApplicationDetail>> getApplicationDetailByStatus(@RequestParam String status) throws Exception{
		try {
			if(applicationDetailservice.getApplicationByStatus(status).isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			 return new ResponseEntity<>(applicationDetailservice.getApplicationByStatus(status),HttpStatus.OK);
		} catch (Exception e) {
			throw new GenericApplicationDetailsException();
		}
		
	}
}
