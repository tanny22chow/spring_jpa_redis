package com.springPrac.springredisdemo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Applicant")
public class Applicant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long applicant_id;
	@Column(name = "identification_num")
	@NotNull
	private String identification_num;
	@NotNull
	private String name;
	@NotNull
	@Min(value = 18)
	private int age;
	@NotNull
	@OneToOne(cascade = { CascadeType.ALL},orphanRemoval=true)
	@JsonManagedReference
	private Location address;
	@OneToOne(mappedBy = "applicant")
	@JoinColumn(name = "application_cd")
	@JsonBackReference
	private ApplicationDetail applicationDetail;

}
