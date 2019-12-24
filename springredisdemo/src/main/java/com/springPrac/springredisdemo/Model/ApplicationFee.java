package com.springPrac.springredisdemo.Model;
import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationFee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fee_process_cd;
    private Long transaction_id;
    @OneToOne(mappedBy = "applicationFee")
    @JsonBackReference
    private ApplicationDetail applicationDetail;
}
