package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "DongSP")

public class DongSP {

    //relationship Mapping


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;


    @Column(name = "Ma")
    private String ma;


    @Column(name = "Ten")
    private String ten;
}
