package com.springPrac.springredisdemo.Model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ApplicationFee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fee_process_cd;
    private Long transaction_id;
    @OneToOne (mappedBy = "applicationFee")
    private ApplicationDetail applicationDetail;
}
