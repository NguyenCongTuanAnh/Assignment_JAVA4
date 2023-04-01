package com.fpt.poly.selling_assignment_ph191690.entity;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "SanPham")
public class SanPham {

    //relationship Mapping


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "Ma")
    private String ma;


    @Column(name = "Ten")
    private String ten;
}
