package com.fpt.poly.selling_assignment_ph191690.servlet;

import com.fpt.poly.selling_assignment_ph191690.responsive.Cart;
import com.fpt.poly.selling_assignment_ph191690.responsive.ChiTiepSPResponse;
import com.fpt.poly.selling_assignment_ph191690.service.CTSPService;
import com.fpt.poly.selling_assignment_ph191690.service.CTSPServiceImpl.CTSPServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "CartServlet", value = {"/add-cart", "/view-cart", "/remove"})
public class CartServlet extends HttpServlet {
    List<String> idList = new ArrayList<>();
    List<Cart> productCartList = new ArrayList<>();
    CTSPService ctspService = new CTSPServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add-cart")) {
            cartAddFunc(request, response);
        } else if (uri.contains("view-cart")) {
            viewCartFunc(request, response);

        } else if (uri.contains("remove")) {
            removeFunc(request, response);

        }
    }
    public String totalCash(List<Cart> productCartList){
        long count = 0;
        for (Cart cart : productCartList){
            count += cart.totalMount();
        }

        Locale locale = new Locale("vi", "VN"); // locale để định dạng tiền tệ Việt Nam
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        String moneyString = format.format(count);
        return moneyString;
    }
    private void removeFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String position = request.getParameter("id");
        productCartList.remove(Integer.parseInt(position));
        HttpSession session = request.getSession();
        request.setAttribute("totalCount", totalCash(productCartList));
        session.setAttribute("productCartList", productCartList);
        request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
    }
    private void viewCartFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("totalCount", totalCash(productCartList));
        session.setAttribute("productCartList", productCartList);
        request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
    }
    private void cartAddFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        idList.add(id);
        ChiTiepSPResponse chiTiepSPResponse = this.ctspService.getOne(id);
        int check = 0;
        for (int i = 0; i < productCartList.size(); i++) {
            if (productCartList.get(i).getId().equals(id)) {
                productCartList.get(i).setSoLuong(productCartList.get(i).getSoLuong() + 1);
                check = 1;
            }
        }
        if (check == 0) {
            productCartList.add(new Cart(id, chiTiepSPResponse.getTenSP(), chiTiepSPResponse.getDongSP(), chiTiepSPResponse.getNamBH(), chiTiepSPResponse.getTenMauSac(), 1, chiTiepSPResponse.getGiaBan()));

        }
        HttpSession session = request.getSession();
        request.setAttribute("totalCount", totalCash(productCartList));
        session.setAttribute("productCartList", productCartList);
        request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
