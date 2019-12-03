<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sportsbetting</title>
    <sec:csrfMetaTags />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4 text-center"><spring:message code="login.welcome"/></h1>
        <p class="lead text-center"><spring:message code="login.welcome.sub"/></p>
    </div>

    <div>
        <h1><spring:message code="login.text"/></h1>
    </div>

    <div class="card card-login">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${not empty param.error}"><div>${param.error}</div></c:if>
            <c:if test="${not empty param.logout}"><div>${param.logout}</div></c:if>
            <form action="<c:url value='/login' />" method="post">
                <input required type="text" class="form-control" id="username" name="username" placeholder='<spring:message code="login.email"/>'>
                <input required type="password" class="form-control" id="password" name="password" placeholder='<spring:message code="login.password"/>'>
                </br>
                <input type="submit" class="btn btn-primary my-2 my-sm-0"  value='<spring:message code="login.button.sign_in"/>'/>
                <a class="btn btn-primary my-2 my-sm-0" href="/register"><spring:message code="register"/></a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>