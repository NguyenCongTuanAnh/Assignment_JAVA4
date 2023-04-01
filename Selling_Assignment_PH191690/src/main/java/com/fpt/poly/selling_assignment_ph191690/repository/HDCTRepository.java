package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.CTSP;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDon;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDonChiTiet;
import com.fpt.poly.selling_assignment_ph191690.until.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HDCTRepository {

    List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From HoaDonChiTiet ", HoaDonChiTiet.class);
            hoaDonChiTiets = query.getResultList();
            return hoaDonChiTiets;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addFunc(List<CTSP> ctsp, HoaDon hd ) {



        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();


            for(CTSP o: ctsp){
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setHoaDon(hd);
                hoaDonChiTiet.setCtsp(o);
                hoaDonChiTiet.setDonGia(100.0);
                hoaDonChiTiet.setSoLuong((long) 10);
                session.save(hoaDonChiTiet);
            }

            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        HDCTRepository hdctRepository = new HDCTRepository();
        HoaDonRepository hdRepository= new HoaDonRepository();
        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
        List<CTSP> ctspList = chiTietSanPhamRepository.getAll();
        List<HoaDon> hoaDonList = hdRepository.getAll();
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(new HoaDon(),new CTSP(), 100L, 10000.0);

        System.out.println(hdctRepository.addFunc(ctspList,hoaDonList.get(0)));

    }
}
