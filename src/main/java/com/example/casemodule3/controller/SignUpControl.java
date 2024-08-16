package com.example.casemodule3.controller;

import com.example.casemodule3.dao.DAO;
import com.example.casemodule3.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class SignUpControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("pass");
        String re_pass = req.getParameter("repass");


            DAO dao = new DAO();
            Account a = dao.checkAccountExist(user);
            if (a == null) {
                System.out.println("co");
                dao.signup(user, password);
                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
            }else {
                System.out.println("khong");
                resp.sendRedirect("home");
            }



            }
    }

