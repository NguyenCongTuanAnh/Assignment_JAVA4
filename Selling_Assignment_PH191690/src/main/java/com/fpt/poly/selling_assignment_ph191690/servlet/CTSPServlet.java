package com.fpt.poly.selling_assignment_ph191690.servlet;

import com.fpt.poly.selling_assignment_ph191690.responsive.ChiTiepSPResponse;
import com.fpt.poly.selling_assignment_ph191690.service.CTSPService;
import com.fpt.poly.selling_assignment_ph191690.service.CTSPServiceImpl.CTSPServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CTSPServlet", value = {
        "/display"

})
public class CTSPServlet extends HttpServlet {

    CTSPService ctspService = new CTSPServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("display")) {
            allDisplay(request, response);
        }
    }

    private void allDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTiepSPResponse> chiTiepSPResponses = this.ctspService.getAll();
        request.setAttribute("chiTiepSPResponses", chiTiepSPResponses);
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
