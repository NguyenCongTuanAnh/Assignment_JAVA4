package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "NSX")
public class NSX {

    //relationship Mapping


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "Ma")
    private String ma;


    @Column(name = "Ten")
    private String ten;
}
