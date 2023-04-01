package com.fpt.poly.selling_assignment_ph191690.repository;

import com.fpt.poly.selling_assignment_ph191690.entity.CTSP;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDon;
import com.fpt.poly.selling_assignment_ph191690.entity.HoaDonChiTiet;
import com.fpt.poly.selling_assignment_ph191690.until.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    List<HoaDon> getAll(){
        List<HoaDon> hoaDonList = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("From HoaDon ");
            hoaDonList = query.getResultList();
            return hoaDonList;
        }catch (Exception e){
            e.printStackTrace();
        }

        return  null;
    }


    public static void main(String[] args) {
        new HoaDonRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}
