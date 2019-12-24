package com.springPrac.springredisdemo.Model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Address", uniqueConstraints = {
        @UniqueConstraint(columnNames = "address_cd")})
public class Adress implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="address_cd")
    private Long address_cd;
    @NotNull
    private  String city;
    @NotNull
    private int zip_cd;
    @NotNull
    private String type;
    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH })
    @JoinColumn(name="loc_cd")
    @JsonBackReference
    private Location location;
 

}
