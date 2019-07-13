<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
        <h1 class="title">User Form</h1>
        <form:form method="POST" modelAttribute="user" enctype="multipart/form-data" class="contact-form">
        <form:input type="hidden" path="id" id="id"/>
        <div class="container">
        <div class="contact-form row">
            <div class="form-field col-6">
                <label class="label1 font-weight-bold" for="firstname">First Name</label>
                    <form:input type="text" path="firstname" id="firstname" class="input-text js-input"/>
                    <form:errors path="firstname" class="help-inline input-text js-input red" />
            </div>
            <div class="form-field col-6">
                <label class="label1 font-weight-bold" for="lastname">Last Name</label>
                <form:input type="text" path="lastname" id="lastname" class="input-text js-input"/>
                <form:errors path="lastname" class="help-inline input-text js-input red"/>
            </div>
        </div>

        <div class="contact-form row">
            <div class="form-field col-6">
                <label class="label1 font-weight-bold" for="country">Country</label>
                <form:input type="text" path="country" id="country" class="input-text js-input"/>
                <form:errors path="country" class="help-inline input-text js-input red"/>
            </div>
            <div class="form-field col-6">
                <label class="label1 font-weight-bold" for="birthdate">Birthdate</label>
                <form:input type="date" path="birthdate" id="birthdate" class="input-text js-input"/>
                <form:errors path="birthdate" class="help-inline input-text js-input red"/>
            </div>
            </div>

        <div class="contact-form row">
            <div class="form-group col-12">
                <label class="label1 font-weight-bold" for="skills">Skills</label>
                    <form:select path="skills" items="${skills}" multiple="true" itemValue="id" itemLabel="name" class="form-control" />
                    <div class="has-error">
                        <form:errors path="skills" class="help-inline red"/>
                    </div>
                </div>
            </div>

            <div class="contact-form row">
            <div class="form-group col-6">
                <label class="label1 font-weight-bold" for="role">Role</label>
                    <form:select path="role" items="${role}" itemValue="id" itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="role" class="help-inline red"/>
                    </div>
            </div>
            <div class="form-group col-6">
                <label class="label1 font-weight-bold" for="status">Status</label>
                    <form:select path="status" items="${status}" itemValue="id" itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="status" class="help-inline red"/>
                    </div>
            </div>
        </div>
        <br><br>
        <div class="contact-form row">
            <div class="form-group col-12">
                <label class="label2 font-weight-bold" for="file">Upload a file</label>
                    <input type="file" name="file" class="btn btn-primary btn-sm submit-btn1" accept="image/png, image/jpeg">
            </div>
        </div>
        <br><br>
        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm submit-btn"/> or
                        <a href="<c:url value='/list' />" class="cancel custom font-weight-bold">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm submit-btn"/> or
                        <a href="<c:url value='/list' />" class="cancel custom font-weight-bold">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        </div>
    </form:form>
</body>
</html>
