package com.springPrac.springredisdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springPrac.springredisdemo.Model.Adress;

@Repository
public interface AddressRepository extends JpaRepository<Adress, Integer> {

}
