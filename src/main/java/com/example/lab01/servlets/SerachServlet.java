package com.example.lab01.servlets;

import com.example.lab01.db.DBManager;
import com.example.lab01.db.Students;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SerachServlet", value = "/search")
public class SerachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Search Servlet");
        String searchBy = request.getParameter("searchBy");
        String searchText = request.getParameter("searchText");
        System.out.println(searchBy + searchText);
        ArrayList<Students> sortedStudents = new ArrayList<>();

        switch (searchBy) {
            case "name": {
                sortedStudents = DBManager.getByName(searchText);
                break;
            }
            case "surname": {
                sortedStudents = DBManager.getBySurname(searchText);
                break;
            }
            case "group": {
                sortedStudents = DBManager.getByGroup(searchText);
                break;
            }
            case "addmited_year": {
                sortedStudents = DBManager.getByYear(searchText);
                break;
            }
            case "none": {
                sortedStudents = DBManager.getStudents();
                break;
            }
            default: {
                sortedStudents = DBManager.getStudents();
                break;
            }
        }
        request.setAttribute("students", sortedStudents);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
