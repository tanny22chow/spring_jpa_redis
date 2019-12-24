package com.springPrac.springredisdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springPrac.springredisdemo.Model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>{
	
}
