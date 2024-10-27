<%@ page import="java.util.List" %>
<%@ page import="ru.ssau.lab1.model.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update car</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 500px;
      margin: 0 auto;
      background-color: #ffffff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
      color: #333;
      text-align: center;
      margin-bottom: 20px;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: block;
      margin-bottom: 5px;
      color: #666;
    }
    .form-control, .form-select {
      width: 100%;
      padding: 8px;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
      font-size: 16px;
    }
    .btn {
      display: inline-block;
      padding: 10px 15px;
      background-color: #ffc107;
      color: #000;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      transition: background-color 0.3s;
    }
    .btn:hover {
      background-color: #e0a800;
    }
  </style>
</head>
<body>
<%
  List<Long> ownerIds = (List<Long>) request.getAttribute("ownerIds");
  Car car = (Car) request.getAttribute("car");
%>
<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/update-car">
    <h1>Update car</h1>
    <input type="hidden" name="carId" value="<%= car.getId() %>">
    <div class="form-group">
      <label for="modelName">modelName: </label>
      <input class="form-control" id="modelName" name="modelName" type="text"
             value="<%= car.getModelName()%>" required/>
    </div>
    <div class="form-group">
      <label for="brand">Class: </label>
      <select class="form-select" id="brand" name="brand" type="text">
        <option value="<%= car.getBrand() %>" selected><%= car.getBrand() %></option>
        <option value="BMW">BMW</option>
        <option value="Kia">Kia</option>
        <option value="Toyota">Toyota</option>
        <option value="Geely">Geely</option>
        <option value="Exeed">Exeed</option>
      </select>
    </div>
    <div class="form-group">
      <label for="ownerId">Owner id: </label>
      <select class="form-control" id="ownerId" name="ownerId" required>
        <% for (Long ownerId : ownerIds) {%>
        <% if (ownerId.equals(car.getOwner().getId())) {%>
        <option value="<%= ownerId %>" selected><%= ownerId %></option>
        <% } else { %>
        <option value="<%= ownerId %>"><%= ownerId %></option>
        <% } %>
        <% } %>
      </select>
    </div>
    <br>
    <input type="submit" value="Update" class="btn"/>
  </form>
</div>
</body>
</html>