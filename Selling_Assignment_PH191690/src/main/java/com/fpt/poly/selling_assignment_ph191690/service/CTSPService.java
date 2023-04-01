package com.fpt.poly.selling_assignment_ph191690.service;

import com.fpt.poly.selling_assignment_ph191690.repository.ChiTietSanPhamRepository;
import com.fpt.poly.selling_assignment_ph191690.responsive.ChiTiepSPResponse;

import java.util.List;

public interface CTSPService {

    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    List<ChiTiepSPResponse> getAll();

    ChiTiepSPResponse getOne(String id);

}
