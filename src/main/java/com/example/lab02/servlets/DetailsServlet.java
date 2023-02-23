package com.example.lab02.servlets;

import com.example.lab02.db.Car;
import com.example.lab02.db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DetailsServlet", value = "/detailsCar")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        Car car = DBManager.getCar(model);

        if (car != null) {
            request.setAttribute("car", car);
            request.getRequestDispatcher("/carDetails.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
