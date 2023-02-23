package com.example.lab01.db;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddItemServlet", value = "/add")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("student_name");
        String surname = request.getParameter("student_surname");
        String group = request.getParameter("student_group");
        String addmitedYear = request.getParameter("student_addmitedYear");

        Students student = new Students();
        student.setName(name);
        student.setSurname(surname);
        student.setGroup(group);
        student.setAddmitedYear(addmitedYear);

        DBManager.addStudent(student);

        response.sendRedirect("/index");
    }
}
