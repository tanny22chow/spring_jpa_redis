package com.springPrac.springredisdemo.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Address", uniqueConstraints = {
        @UniqueConstraint(columnNames = "address_cd"),@UniqueConstraint(columnNames = "identification_num")})
public class Applicant implements Serializable {

    @Column(name="ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @OneToOne(mappedBy = "applicant",cascade = {CascadeType.ALL})
    private Location address;

}
