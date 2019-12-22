package com.springPrac.springredisdemo.Controller;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Service.ApplicationDetailsevice;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(path = "/createapplication",consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createApplication(@Valid @RequestBody ApplicationDetail applicationDetail){
        applicationDetailservice.createNewApplication(applicationDetail);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri()).build();

    }
    
}
