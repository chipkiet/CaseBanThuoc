package com.example.casemodule3.controller;

import com.example.casemodule3.dao.DAO;
import com.example.casemodule3.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/managerProduct")
public class ManagerProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer sellID = (Integer) session.getAttribute("isSell");
        System.out.println("SellID: " + sellID);

        if (sellID != null && sellID > 0) {
            DAO dao = new DAO();
            List<Product> list = dao.getProductBySellId(sellID);
            req.setAttribute("products", list);
        }

        req.getRequestDispatcher("/WEB-INF/view/managerProduct.jsp").forward(req, resp);
    }
}
