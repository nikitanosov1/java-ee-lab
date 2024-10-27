package ru.ssau.lab1.servlets;

import ru.ssau.lab1.appbean.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteOwnerServlet", value = "/DeleteOwnerServlet", urlPatterns = "/delete-owner")
public class DeleteOwnerServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ownerId = Long.parseLong(request.getParameter("ownerId"));
        appBean.deleteOwner(ownerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
