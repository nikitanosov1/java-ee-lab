<%@ page import="java.util.List" %>
<%@ page import="ru.ssau.lab1.model.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create car</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
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
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <% List<Long> ownerIds = (List<Long>) request.getAttribute("ownerIds"); %>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/create-car">
        <h1>Create car</h1>
        <div class="form-group">
            <label for="modelName">Model name: </label>
            <input class="form-control" id="modelName" name="modelName" type="text" required/>
        </div>
        <div class="form-group">
            <label for="brand">brand: </label>
            <select class="form-select" id="brand" name="brand">
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
                <option value="<%= ownerId %>"><%= ownerId %></option>
                <%}%>
            </select>
        </div>
        <br>
        <input type="submit" value="Create" class="btn"/>
    </form>
</div>
</body>
</html>