package com.springPrac.springredisdemo.Repository;

import com.springPrac.springredisdemo.Model.ApplicationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail,String> {
}
