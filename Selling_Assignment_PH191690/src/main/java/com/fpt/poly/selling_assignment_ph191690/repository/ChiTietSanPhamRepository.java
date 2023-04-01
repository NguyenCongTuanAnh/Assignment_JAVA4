package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.CTSP;
import com.fpt.poly.selling_assignment_ph191690.until.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class ChiTietSanPhamRepository {


    public static void main(String[] args) {

        new ChiTietSanPhamRepository().getAll().forEach(s -> System.out.println(s.toString()));
//
    }


//    List<ChiTiepSPResponse> getAll(){
//        List<ChiTiepSPResponse> chiTietSPResponseList = new ArrayList<>();
//
//        String sql = "SELECT new com.fpt.poly.selling_assignment_ph191690.responsive.ChiTiepSPResponse" +
//                "(ct.id, sp.ten, sx.ten, ms.ten, dsp.ten, ct.namBH, ct.moTa, ct.soLuongTon, ct.giaBan, ct.giaNhap)" +
//                "FROM CTSP ct " +
//                "JOIN SanPham sp " +
//                "ON ct.sanPham.id = sp.id "+
//                "JOIN NSX sx " +
//                "ON ct.nsx.id = sx.id " +
//                "JOIN MauSac ms " +
//                "ON ct.mauSac.id = ms.id " +
//                "JOIN DongSP dsp " +
//                "ON ct.dongSP.id = dsp.id";
//
//        try(Session session = HibernateUtil.getFACTORY().openSession()){
//
//            Query query = session.createQuery(sql);
//            chiTietSPResponseList = query.getResultList();
//
//            return chiTietSPResponseList;
//        }catch (Exception e){
//            e.printStackTrace(System.out);
//        }
//
//        return null;
//    }

    public List<CTSP> getAll() {
        List<CTSP> chiCtspList = new ArrayList<>();

        String sql = "SELECT ct FROM CTSP ct JOIN FETCH ct.sanPham JOIN FETCH ct.nsx JOIN FETCH ct.dongSP JOIN FETCH ct.mauSac ";

        try (Session session = HibernateUtil.getFACTORY().openSession()) {

            Query query = session.createQuery(sql);
            chiCtspList = query.getResultList();

            return chiCtspList;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    public CTSP getOne(String id) {


        String sql = "SELECT ct FROM CTSP ct JOIN FETCH ct.sanPham JOIN FETCH ct.nsx JOIN FETCH ct.dongSP JOIN FETCH ct.mauSac  WHERE ct.id =: reID";

        CTSP ctsp = new CTSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {

            Query query = session.createQuery(sql);
            query.setParameter("reID", id);
            ctsp = (CTSP) query.getSingleResult();

            return ctsp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;
    }
}
