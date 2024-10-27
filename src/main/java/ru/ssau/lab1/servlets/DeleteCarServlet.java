package ru.ssau.lab1.servlets;

import ru.ssau.lab1.appbean.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCarServlet", value = "/DeleteCarServlet", urlPatterns = "/delete-car")
public class DeleteCarServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("carId"));
        appBean.deleteCar(carId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
