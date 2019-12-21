package com.springPrac.springredisdemo.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="Location",uniqueConstraints = {@UniqueConstraint(columnNames = "loc_cd")})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loc_cd")
    private int loc_cd;
    @NotNull
    @OneToMany(mappedBy = "location")
    private List<Adress> addr;
    @OneToOne(mappedBy = "address")
    private Applicant applicant;
}
