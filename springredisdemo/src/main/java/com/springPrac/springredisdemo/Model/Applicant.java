package com.springPrac.springredisdemo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Applicant", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "identification_num") })
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
	@OneToOne(cascade = { CascadeType.ALL })
	private Location address;
	@OneToOne(mappedBy = "applicant")
	@JoinColumn(name = "application_cd")
	private ApplicationDetail applicationDetail;

}
