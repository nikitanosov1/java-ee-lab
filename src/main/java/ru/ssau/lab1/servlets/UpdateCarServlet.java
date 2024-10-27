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
import java.util.stream.Collectors;

@WebServlet(name = "UpdateCarServlet", value = "/UpdateCarServlet", urlPatterns = "/update-car")
public class UpdateCarServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("carId"));
        Car car = appBean.getCarById(carId);
        request.setAttribute("car", car);
        List<Long> ownerIds = appBean.getAllOwners().stream().map(Owner::getId).collect(Collectors.toList());
        request.setAttribute("ownerIds", ownerIds);
        request.getRequestDispatcher("view/UpdateCar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("carId"));
        String modelName = request.getParameter("modelName");
        String brand = request.getParameter("brand");
        Long ownerId = Long.parseLong(request.getParameter("ownerId"));
        appBean.updateCar(carId, new Car(modelName, brand), ownerId);
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
