<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="card">
    <div class="card-header">
        <spring:message code="account.details"/>
    </div>
    <div class="card-body">

        <form action="/player/savePlayer" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.details.name"/>
                </span>
                </div>
                <input required type="text" class="form-control" name="name" id="name" value="${param.name}">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.details.date_of_birth"/>
                </span>
                </div>
                <input required type="text" class="form-control" name="date_of_birth" id="date_of_birth" value="${param.birth}">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.account_number"/>
                </span>
                </div>
                <input required type="text" class="form-control" name="account_number" id="account_number" value="${param.account_number}">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.currency"/>
                </span>
                </div>
                <input required type="text" class="form-control" name="currency" id="currency" value="${param.currency}">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.balance"/>
                </span>
                </div>
                <input required type="number" class="form-control" name="balance" id="balance" value="${param.balance}">
            </div>

            <input type="submit" class="btn btn-primary" value='<spring:message code="button.save"/>' />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</div>