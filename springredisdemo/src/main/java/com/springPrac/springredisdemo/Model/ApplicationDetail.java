package com.springPrac.springredisdemo.Model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ApplicationDetail")
public class ApplicationDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "application_id")
	private Long application_id;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference
	private Applicant applicant;
	@CreationTimestamp
	private LocalDate date_of_submission;
	@ColumnDefault("15")
	private int SLA;
	private String status;
	private String prcess_fee_stat;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "application_fee_cd")
	@JsonManagedReference
	private ApplicationFee applicationFee;
}
