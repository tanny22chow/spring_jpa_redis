package com.springPrac.springredisdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springPrac.springredisdemo.Model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
