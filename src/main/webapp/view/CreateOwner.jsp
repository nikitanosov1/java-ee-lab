<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create owner</title>
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
        .form-control {
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
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/create-owner">
        <h1>Create owner</h1>
        <div class="form-group">
            <label for="firstName">Owner first name: </label>
            <input class="form-control" id="firstName" name="firstName" type="text" required/>
        </div>
        <div class="form-group">
            <label for="lastName">Owner last name: </label>
            <input class="form-control" id="lastName" name="lastName" type="text" required/>
        </div>
        <div class="form-group">
            <label for="birthdate">Birthday: </label>
            <input class="form-control" id="birthdate" name="birthdate" type="date" required/>
        </div>
        <br>
        <input type="submit" value="Create" class="btn"/>
    </form>
</div>
</body>
</html>