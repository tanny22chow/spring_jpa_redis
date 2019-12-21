package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Repository.ApplicationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationDetailsevice {
    @Autowired
    ApplicationDetailRepository applicationDetailRepository;
    public void createNewApplication(ApplicationDetail applicationDetail) {
        applicationDetailRepository.save(applicationDetail);
    }
}
