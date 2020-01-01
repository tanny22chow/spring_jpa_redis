package com.springPrac.springredisdemo.Repository;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.springPrac.springredisdemo.Model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>, QuerydslPredicateExecutor<Applicant> {
	
}
