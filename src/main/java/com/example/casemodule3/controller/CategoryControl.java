package com.example.casemodule3.controller;

import com.example.casemodule3.dao.DAO;
import com.example.casemodule3.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/category")
public class CategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cateId = req.getParameter("cid");
        DAO dao = new DAO();
        List<Product> list =  dao.getProductByCID(cateId);
        req.setAttribute("listP",list);
        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);

    }
}
