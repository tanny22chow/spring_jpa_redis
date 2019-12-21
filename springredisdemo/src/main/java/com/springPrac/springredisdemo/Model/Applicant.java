package com.springPrac.springredisdemo.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Applicant", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),@UniqueConstraint(columnNames = "identification_num")})
public class Applicant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID")
    private Long applicant_id;
    @Column(name="identification_num")
    @NotNull
    private String identification_num;
    @NotNull
    private  String name;
    @NotNull
    @Min(value = 18)
    private  int age;
    @NotNull
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="location_cd")
    private Location address;
    @OneToOne(mappedBy = "applicant_id")
    private ApplicationDetail applicationDetail;

}
