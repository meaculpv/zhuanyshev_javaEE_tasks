package com.example.lab02.servlets;

import com.example.lab02.db.Car;
import com.example.lab02.db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/editCar")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String model = request.getParameter("model");
        Car car = DBManager.getCar(model);
        if (car != null) {
            request.setAttribute("car", car);
            request.getRequestDispatcher("/carEdit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        double volume = Double.parseDouble(request.getParameter("volume"));
        Car car = DBManager.getCar(model);

        if (car != null) {
            car.setName(name);
            car.setYear(year);
            car.setVolume(volume);

            DBManager.saveCar(car);

            response.sendRedirect("/editCar?model=" + car.getModel() +"?success");
        } else {
            response.sendRedirect("/");
        }
    }
}
