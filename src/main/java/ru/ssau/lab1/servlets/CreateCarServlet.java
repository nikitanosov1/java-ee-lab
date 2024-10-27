package ru.ssau.lab1.servlets;

import ru.ssau.lab1.appbean.AppBean;
import ru.ssau.lab1.model.Owner;
import ru.ssau.lab1.model.Car;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateCarServlet", value = "/CreateCarServlet", urlPatterns = "/create-car")
public class CreateCarServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> ownerIds = appBean.getAllOwners().stream().map(Owner::getId).collect(Collectors.toList());
        request.setAttribute("ownerIds", ownerIds);
        request.getRequestDispatcher("view/CreateCar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modelName = request.getParameter("modelName");
        String brand = request.getParameter("brand");
        Long ownerId = Long.parseLong(request.getParameter("ownerId"));
        appBean.createCar(new Car(modelName, brand), ownerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
