package com.fpt.poly.selling_assignment_ph191690.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString


@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

        @Id
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
        private HoaDon hoaDon;


        @Id
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
        private CTSP ctsp;

        @Column(name = "SoLuong")
        private Long soLuong;
        @Column(name = "DonGia")
    private Double donGia;
}
