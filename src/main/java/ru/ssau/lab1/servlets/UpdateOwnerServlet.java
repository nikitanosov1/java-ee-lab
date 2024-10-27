package ru.ssau.lab1.servlets;

import ru.ssau.lab1.appbean.AppBean;
import ru.ssau.lab1.model.Owner;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UpdateOwnerServlet", value = "/UpdateOwnerServlet", urlPatterns = "/update-owner")
public class UpdateOwnerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ownerId = Long.parseLong(request.getParameter("ownerId"));
        Owner owner = appBean.getOwnerById(ownerId);
        request.setAttribute("owner", owner);
        request.getRequestDispatcher("view/UpdateOwner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ownerId = Long.parseLong(request.getParameter("ownerId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        appBean.updateOwner(ownerId, new Owner(firstName, lastName, birthdate));
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
