package com.springPrac.springredisdemo.Controller;

import com.springPrac.springredisdemo.Service.Applicantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private Applicantservice applicantservice;

    @GetMapping(path = "/dispatchapplicants")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody
    public void publishApplicantToVerificationService(){
        applicantservice.dispatchapplicationToverificationService();
    }
}
