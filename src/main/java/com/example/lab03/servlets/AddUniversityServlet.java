package com.example.lab03.servlets;

import com.example.lab03.db.DBManager;
import com.example.lab03.db.University;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUniversityServlet", value = "/insertUni")
public class AddUniversityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("uniAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortname");
        University university = new University(
                4, name, shortName
        );
        DBManager.addUniversity(university);

        response.sendRedirect("/lab03");
    }
}
