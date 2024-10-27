package ru.ssau.lab1.servlets;

import ru.ssau.lab1.appbean.AppBean;
import ru.ssau.lab1.model.Car;
import ru.ssau.lab1.model.Owner;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "MainPageServlet", value = "/MainPageServlet", urlPatterns = "/main")
public class MainPageServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Owner> owners = appBean.getAllOwners();
        request.setAttribute("owners", owners);
        List<Car> cars = appBean.getAllCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("view/MainPage.jsp").forward(request, response);
    }
}
