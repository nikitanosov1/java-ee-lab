package ru.ssau.lab1.servlets;
import ru.ssau.lab1.appbean.AppBean;
import ru.ssau.lab1.model.Owner;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CreateOwnerServlet", value = "/CreateOwnerServlet", urlPatterns = "/create-owner")
public class CreateOwnerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/CreateOwner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        appBean.createOwner(new Owner(firstName, lastName, birthdate));
        response.sendRedirect(request.getContextPath() + "/main");
    }
}