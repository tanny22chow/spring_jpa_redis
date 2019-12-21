package com.springPrac.springredisdemo.Model;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationFee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fee_process_cd;
    private Long transaction_id;
    @OneToOne(mappedBy = "applicationFee")
    private ApplicationDetail applicationDetail;
}
