package com.springPrac.springredisdemo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Address", uniqueConstraints = {
        @UniqueConstraint(columnNames = "address_cd")})
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="address_cd")
    private Long address_cd;
    @NotNull
    private  String city;
    @NotNull
    private int zip_cd;
    @NotNull
    private String type;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="loc_cd")
    private Location location;

}
