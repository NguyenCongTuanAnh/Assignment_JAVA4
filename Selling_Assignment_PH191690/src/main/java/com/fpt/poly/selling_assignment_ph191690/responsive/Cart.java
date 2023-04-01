package com.fpt.poly.selling_assignment_ph191690.responsive;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    private String id;
    private String tenSP;
    private String dongSP;
    private long namBH;
    private String tenMauSac;
    private long soLuong;
    private long giaBan;

    public long totalMount() {
        return soLuong * giaBan;
    }
}
