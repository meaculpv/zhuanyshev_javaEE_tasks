package com.example.lab02.servlets;

import com.example.lab02.db.Car;
import com.example.lab02.db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Lab02Servlet", value = "/lab02")
public class Lab02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Car> cars = DBManager.getCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/lab02.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
