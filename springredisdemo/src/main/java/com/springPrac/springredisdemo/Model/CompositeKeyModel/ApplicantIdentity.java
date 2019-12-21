package com.springPrac.springredisdemo.Model.CompositeKeyModel;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@Embeddable
public class ApplicantIdentity implements Serializable {
    @NotNull
    private Long applicant_id;
    @NotNull
    private String identification_num;
}
