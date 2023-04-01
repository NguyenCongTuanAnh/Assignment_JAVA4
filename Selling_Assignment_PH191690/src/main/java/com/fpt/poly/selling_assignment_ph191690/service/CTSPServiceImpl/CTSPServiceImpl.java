package com.fpt.poly.selling_assignment_ph191690.service.CTSPServiceImpl;

import com.fpt.poly.selling_assignment_ph191690.entity.CTSP;
import com.fpt.poly.selling_assignment_ph191690.responsive.ChiTiepSPResponse;
import com.fpt.poly.selling_assignment_ph191690.service.CTSPService;

import java.util.ArrayList;
import java.util.List;

public class CTSPServiceImpl implements CTSPService {

    public static void main(String[] args) {
        System.out.println(new CTSPServiceImpl().getOne("175A44F8-1A3B-4C06-ABBB-0DFF2C9C1820").toString());
    }

    public ChiTiepSPResponse modelCovert(CTSP ctsp) {
        ChiTiepSPResponse chiTiepSPResponse = new ChiTiepSPResponse();
        chiTiepSPResponse.setId(ctsp.getId());
        chiTiepSPResponse.setTenSP(ctsp.getSanPham().getTen());
        chiTiepSPResponse.setTenNSX(ctsp.getNsx().getTen());
        chiTiepSPResponse.setTenMauSac(ctsp.getMauSac().getTen());
        chiTiepSPResponse.setDongSP(ctsp.getDongSP().getTen());
        chiTiepSPResponse.setNamBH(ctsp.getNamBH());
        chiTiepSPResponse.setMoTa(ctsp.getMoTa());
        chiTiepSPResponse.setSoLuong(ctsp.getSoLuongTon());
        chiTiepSPResponse.setGiaBan(ctsp.getGiaBan());
        chiTiepSPResponse.setGiaNhap(ctsp.getGiaNhap());


        return chiTiepSPResponse;
    }

    @Override
    public List<ChiTiepSPResponse> getAll() {
        List<CTSP> ctsps = this.chiTietSanPhamRepository.getAll();
        List<ChiTiepSPResponse> chiTiepSPResponses = new ArrayList<>();
        ctsps.forEach(s -> chiTiepSPResponses.add(modelCovert(s)));

        return chiTiepSPResponses;
    }

    @Override
    public ChiTiepSPResponse getOne(String id) {


        CTSP ctsp = this.chiTietSanPhamRepository.getOne(id);

        return modelCovert(ctsp);
    }
}
