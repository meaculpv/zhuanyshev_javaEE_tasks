package com.example.lab03.servlets;

import com.example.lab02.db.Car;
import com.example.lab03.db.DBManager;
import com.example.lab03.db.University;
import com.example.lab03.db.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Lab03Servlet", value = "/lab03")
public class Lab03Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> users = DBManager.getUsers();
        ArrayList<University> universities = DBManager.getUniversities();
        request.setAttribute("universities", universities);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/lab03.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
