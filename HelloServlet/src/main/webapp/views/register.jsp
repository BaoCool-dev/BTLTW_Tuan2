<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: Arial, sans-serif;
        }
        .register-container {
            max-width: 450px;
            width: 100%;
            padding: 2rem;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-control:focus {
            border-color: #0d6efd;
            box-shadow: 0 0 5px rgba(13, 110, 253, 0.5);
        }
        .btn-primary {
            background-color: #0d6efd;
            border: none;
            padding: 0.75rem;
            width: 100%;
            transition: background-color 0.3s;
        }
        .btn-primary:hover {
            background-color: #0b5ed7;
        }
        .text-muted {
            text-align: center;
            margin-top: 1rem;
        }
        .text-muted a {
            color: #0d6efd;
            text-decoration: none;
        }
        .text-muted a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2 class="text-center mb-4">Create a New Account</h2>
        <c:if test="${alert != null}">
            <div class="alert alert-danger" role="alert">${alert}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label for="userName" class="form-label">User name</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" id="userName" name="userName" class="form-control" placeholder="Enter username" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="fullName" class="form-label">Full Name</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" id="fullName" name="fullName" class="form-control" placeholder="Enter full name" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Enter email" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone Number</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                    <input type="tel" id="phone" name="phone" class="form-control" placeholder="Enter phone number" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="_password" class="form-label">Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" id="_password" name="_password" class="form-control" placeholder="Enter password" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Create Account</button>
            <p class="text-muted">Already have an account? 
                <a href="${pageContext.request.contextPath}/login">Sign in</a>
            </p>
        </form>
    </div>
</body>
</html>
