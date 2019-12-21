package com.springPrac.springredisdemo.Model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="ApplicationDetail",uniqueConstraints = {@UniqueConstraint(columnNames = {"application_id"})})
public class ApplicationDetail implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "uuid")
    @Column(name="application_id")
    private Long application_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="applicant_id")
    private Applicant applicant_id;
    private Date date_of_submission;
    @ColumnDefault("15")
    private int SLA;

}
