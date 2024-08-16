package com.example.casemodule3.controller;

import com.example.casemodule3.dao.DAO;
import com.example.casemodule3.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/detail")
public class DetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);

        req.setAttribute("detail", p);
        req.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(req, resp);
    }
}
