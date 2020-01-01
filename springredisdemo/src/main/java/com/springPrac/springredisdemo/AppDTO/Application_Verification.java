package com.springPrac.springredisdemo.AppDTO;

import java.io.Serializable;
import com.springPrac.springredisdemo.Model.Adress;
import com.springPrac.springredisdemo.Model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Application_Verification implements Serializable{
	private Long application_Id;
	private Long applicant_Id;
	private Adress address;

}
