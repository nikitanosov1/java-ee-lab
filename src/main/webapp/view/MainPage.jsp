<%@ page import="java.util.List" %>
<%@ page import="ru.ssau.lab1.model.Owner" %>
<%@ page import="ru.ssau.lab1.model.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
        }
        .text-center {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        caption {
            font-weight: bold;
            margin-bottom: 10px;
        }
        .btn {
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
        }
        .btn-success {
            background-color: #4CAF50;
            color: white;
        }
        .btn-warning {
            background-color: #ff9800;
            color: white;
        }
        .btn-danger {
            background-color: #f44336;
            color: white;
        }
        .owners-table {
            background-color: #e1f5fe;
        }
        .cars-table {
            background-color: #e8f5e9;
        }
    </style>
</head>
<body>
<% List<Owner> owners = (List<Owner>) request.getAttribute("owners"); %>
<% List<Car> cars = (List<Car>) request.getAttribute("cars"); %>
<div class="container">
    <table class="owners-table">
        <caption>Owners</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>birthday</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Owner owner : owners) { %>
        <tr>
            <td><%= owner.getId() %></td>
            <td><%= owner.getFirstName() %></td>
            <td><%= owner.getLastName() %></td>
            <td><%= owner.getBirthdate() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/update-owner">
                    <input type="hidden" name="ownerId" value="<%= owner.getId() %>">
                    <input type="submit" class="btn btn-warning" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-owner" method="post">
                    <input type="hidden" name="ownerId" value="<%= owner.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/create-owner" method="get">
            <button class="btn btn-success">Create owner</button>
        </form>
    </div>
    <br>

    <table class="cars-table">
        <caption>Cars</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>brand</th>
            <th>modelName</th>
            <th>ownerId</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Car car : cars) { %>
        <tr>
            <td><%= car.getId() %></td>
            <td><%= car.getBrand() %></td>
            <td><%= car.getModelName() %></td>
            <td><%= car.getOwner().getId() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/update-car">
                    <input type="hidden" name="carId" value="<%= car.getId() %>">
                    <input type="submit" class="btn btn-warning" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-car" method="post">
                    <input type="hidden" name="carId" value="<%= car.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/create-car" method="get">
            <button class="btn btn-success">Create car</button>
        </form>
    </div>
    <br>
</div>
</body>
</html>