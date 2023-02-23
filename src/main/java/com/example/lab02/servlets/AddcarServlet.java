package com.example.lab02.servlets;

import com.example.lab02.db.Car;
import com.example.lab02.db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddcarServlet", value = "/addCar")
public class AddcarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("lab02.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        double volume = Double.parseDouble(request.getParameter("volume"));
        Car car = new Car(name, model, year, volume);
        DBManager.addCar(car);

        response.sendRedirect("/lab02?success");
    }
}
