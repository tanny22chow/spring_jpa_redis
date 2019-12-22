package com.springPrac.springredisdemo.Service;

import com.springPrac.springredisdemo.Model.Adress;
import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.Location;
import com.springPrac.springredisdemo.Repository.AddressRepository;
import com.springPrac.springredisdemo.Repository.ApplicationDetailRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationDetailsevice {
    @Autowired
    ApplicationDetailRepository applicationDetailRepository;
    @Autowired
    AddressRepository addressrepo;
    public void createNewApplication(ApplicationDetail applicationDetail) {
    	Location loc=applicationDetail.getApplicant().getAddress();
    	List<Adress> adl=new ArrayList<Adress>();
    	loc.getAddressList().forEach(add->{
    		adl.add(add);
    		add.setLocation(loc);
    	});
    	loc.setAddressList(adl);
    	applicationDetail.getApplicant().setAddress(loc);
        applicationDetailRepository.save(applicationDetail);
//    	List<Adress> adr1=applicationDetail.getApplicant().getAddress().getAddress();
//    	adr1.forEach(adr->{
//    		addressrepo.save(adr);
//    	});
    }
}
