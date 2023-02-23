package com.example.lab03.servlets;

import com.example.lab03.db.DBManager;
import com.example.lab03.db.University;
import com.example.lab03.db.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("lab03.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        int universityID = Integer.parseInt(request.getParameter("university_name"));
        System.out.println(universityID);

        University uni = DBManager.getUniversity(universityID);
        String uni_name = uni.getUniversityName();
        String uni_shortname = uni.getUniversityShortName();
        DBManager.addUser(new User(
                1, name, surname, age, new University(
                        universityID, uni_name, uni_shortname
        )
        ));

        response.sendRedirect("/lab03?success");

    }
}
