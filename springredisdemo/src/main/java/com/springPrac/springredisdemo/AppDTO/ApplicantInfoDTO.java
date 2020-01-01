package com.springPrac.springredisdemo.AppDTO;

import com.springPrac.springredisdemo.Model.Adress;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicantInfoDTO implements Serializable {
    private String identification_num;
    private String name;
    private int age;
    private List<Adress> address;

}
