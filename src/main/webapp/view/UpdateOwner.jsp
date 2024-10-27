<%@ page import="ru.ssau.lab1.model.Owner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update owner</title>
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
    .form-control {
      width: 100%;
      padding: 8px;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
    }
    .btn {
      display: inline-block;
      padding: 10px 15px;
      background-color: #ff9800;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
    .btn:hover {
      background-color: #f57c00;
    }
  </style>
</head>
<body>
<% Owner owner = (Owner) request.getAttribute("owner"); %>
<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/update-owner">
    <h1>Update owner</h1>
    <input type="hidden" name="ownerId" value="<%= owner.getId() %>">
    <div class="form-group">
      <label for="firstName">First name: </label>
      <input class="form-control" id="firstName" name="firstName" type="text"
             value="<%= owner.getFirstName() %>" required/>
    </div>
    <div class="form-group">
      <label for="lastName">Last name: </label>
      <input class="form-control" id="lastName" name="lastName" type="text"
             value="<%= owner.getLastName() %>" required/>
    </div>
    <div class="form-group">
      <label for="birthdate">Birthday: </label>
      <input class="form-control" id="birthdate" name="birthdate" type="date"
             value="<%= owner.getBirthdate() %>" required/>
    </div>
    <br>
    <input type="submit" value="Update" class="btn"/>
  </form>
</div>
</body>
</html>