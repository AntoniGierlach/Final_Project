<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Zarejestruj się</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


    <style>
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        body {
            height: 100%;
        }

        body {
            display: flex;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
        }

        .form-signin .form-floating:focus-within {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body class="text-center">

<main class="form-signin w-100 m-auto">
    <form:form method="post" modelAttribute="registerDto">
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-person-plus"
             viewBox="0 0 16 16">
            <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
            <path fill-rule="evenodd"
                  d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
        </svg>
        <h1 class="h3 mb-3 fw-normal">Zarejestruj się</h1>


        <div class="form-floating">
            <input type="text" id="firstName" name="name" class="form-control" placeholder="First name"
                   required="required" autofocus="autofocus">
            <label for="firstName">Imię</label>
            <form:errors path="name"/>
        </div>

        <div class="form-floating">
            <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username"
                   required="required">
            <label for="inputUsername">Nazwa użytkownika</label>
            <form:errors path="username"/>
        </div>
        <div class="form-floating">
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password"
                   required="required">
            <label for="inputPassword">Hasło</label>
            <form:errors path="password"/>
        </div>

        <div class="form-floating">
            <input type="password" id="confirmPassword" name="confirm_password" class="form-control"
                   placeholder="Confirm password" required="required">
            <label for="confirmPassword">Potwierdź hasło</label>
            <form:errors path="confirm_password"/>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Zarejestruj</button>
    </form:form>

    <div class="text-center">
        <a class="d-block small mt-3" href="/login">Zaloguj się</a>
        <p class="mt-5 mb-3 text-muted">&copy; Final Project 2022</p>
    </div>
</main>
</body>
</html>