package com.springPrac.springredisdemo.Repository;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import com.springPrac.springredisdemo.Model.QApplicationDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail, Long> ,
QuerydslPredicateExecutor<ApplicationDetail>{

	@Query(value = "select * from application_detail a where a.applicant_id=:applicantId", nativeQuery = true)
	ApplicationDetail getApplicationByApplicantId(@Param("applicantId") Long applicantId);

	@Transactional
	@Modifying
	@Query(value = "delete from ApplicationDetail where status=:status")
	public void deleteApplicationDetailsByApplicationStatus(String status);


}
