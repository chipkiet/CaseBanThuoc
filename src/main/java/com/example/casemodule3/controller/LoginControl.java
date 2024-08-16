package com.example.casemodule3.controller;

import com.example.casemodule3.dao.DAO;
import com.example.casemodule3.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        DAO dao = new DAO();
        Account a = dao.login(username, password );
        if (a == null) {

            req.setAttribute("mess", "Sai mật khẩu hoặc tài khoản, hãy nhập lại");
            req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
        }else{
            System.out.println("Voo");
            HttpSession session =  req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("isAdmin", a.getIsAdmin());
            session.setAttribute("isSell", a.getIsSell());
            resp.sendRedirect(req.getContextPath()+"/home");
        }
    }
}
