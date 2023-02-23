package com.example.lab02.servlets;

import com.example.lab02.db.Car;
import com.example.lab02.db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/deleteCar")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        Car car = DBManager.getCar(model);
        System.out.println(car.getModel());

        if (car != null) {
            DBManager.deleteCar(car);

            response.sendRedirect("/");
        } else {
            response.sendRedirect("/");
        }
    }
}
