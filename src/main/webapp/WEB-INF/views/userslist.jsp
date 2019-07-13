<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<h1 class="title">User List</h1>
<div class="container">
    <div class="card">
        <table class="table table-hover shopping-cart-wrap">
            <thead class="text-muted">
            <tr>
                <th scope="col" class="custom">Profile</th>
                <th scope="col" class="custom">Firstname</th>
                <th scope="col" class="custom">Lastname</th>
                <th scope="col" class="custom">Country</th>
                <th scope="col" class="custom">BirthDate</th>
                <th scope="col" class="custom">Role</th>
                <th scope="col" class="custom">Status</th>
                <th scope="col" class="custom">Skill</th>
                <th scope="col" class="custom">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
            <tr>
                <td><div class="thumbnail"><img src="<c:url value='/pictures/${user.fileName}' />" class="portrait">
                </div>
                </td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.country}</td>
                <td><fmt:formatDate type="date" value="${user.birthdate}"/></td>
                <td>${user.role.name}</td>
                <td>${user.status.name}</td>
                <td>
                    <c:forEach items="${user.skills}" varStatus="loopStatus" var="skills">
                        <c:out value="${skills.name}"/>
                        <c:if test="${!loopStatus.last}">,</c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-outline-success btn-round">edit</a>
                    <a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-outline-danger btn-round">× Remove</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
