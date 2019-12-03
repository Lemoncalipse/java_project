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

<%@include file="components/navbar.jsp" %>

<div class="container">

    <jsp:include page="page/account_details.jsp">
        <jsp:param name="name" value="${player.getName()}" />
        <jsp:param name="birth" value="${player.getBirth()}" />
        <jsp:param name="account_number" value="${player.getAccountNumber()}" />
        <jsp:param name="currency" value="${player.getCurrency()}" />
        <jsp:param name="balance" value="${player.getBalance()}" />
    </jsp:include>

    <div class="card">
        <div class="card-header"><spring:message code="wagers"/></div>
        <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">#</th>
                        <th scope="col"><spring:message code="wagers.event_title"/></th>
                        <th scope="col"><spring:message code="wagers.event_type"/></th>
                        <th scope="col"><spring:message code="wagers.bet_type"/></th>
                        <th scope="col"><spring:message code="wagers.outcome_value"/></th>
                        <th scope="col"><spring:message code="wagers.outcome_odd"/></th>
                        <th scope="col"><spring:message code="wagers.amount"/></th>
                        <th scope="col"><spring:message code="wagers.winner"/></th>
                        <th scope="col"><spring:message code="wagers.processed"/><th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${wagers}" var="wager">
                        <tr>
                            <td></td>
                            <td>
                                <c:if test="${!wager.isProcessed()}">
                                    <input type="button" onclick="removeWager(${wager.getId()})" class="btn btn-primary" value='<spring:message code="button.remove"/>'>
                                </c:if>
                            </td>
                           <td>${wager.getOdd().getOutcome().getBet().getEvent().getTitle()}</td>
                            <td>${wager.getOdd().getOutcome().getBet().getEvent().getClass().toString()}</td>
                            <td>${wager.getOdd().getOutcome().getBet().getType().name()}</td>
                            <td>${wager.getOdd().getValue()}</td>
                            <td>${wager.getOdd().getOutcome()}</td>
                            <td>${wager.getAmount()}</td>
                            <td>${wager.isWin()}</td>
                            <td>${wager.isProcessed()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>

<script c:inline="javascript">
    function removeWager(wager_id) {
        if(confirm("Delete this Wager?") == true) {
            const body = new FormData();
            body.append("wager_id", wager_id);

            const headers = new Headers({
                // 'Content-Type': 'x-www-form-urlencoded',
                'X-CSRF-TOKEN': "${_csrf.token}"
            });

            fetch('/removeWager',
                {
                    method: "POST",
                    headers,
                    credentials: 'include',
                    body
                }
            ).then((res) => location.reload())
            .catch((err) => alert("ERR"));
        }
    }
</script>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>