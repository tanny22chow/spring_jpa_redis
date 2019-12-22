package com.springPrac.springredisdemo.Repository;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail,String> {

	@Query(value="select * from application_detail a where a.applicant_id=:applicantId",nativeQuery=true)
	ApplicationDetail getApplicationByApplicantId(@Param("applicantId")Long applicantId);
}
