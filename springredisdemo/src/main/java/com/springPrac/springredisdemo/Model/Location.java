package com.springPrac.springredisdemo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Location")
public class Location implements Serializable {
 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loc_cd")
    private int loc_cd;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "location",orphanRemoval=true)
    @JsonManagedReference
    private List<Adress> addressList;
    @OneToOne(mappedBy = "address")
    @JoinColumn(name="applicant_cd")
    @JsonBackReference
    private Applicant applicant;
 
}
