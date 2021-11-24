<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>CRM</title>
</head>
<body>
<div class="container mt-3">
    <a class="btn btn-primary" href="<c:url value='/create'/>"role="button">Add Page</a>
    <button type="button" class="btn btn-primary">Toggle</button>
    <div class="row">
        <h4>Тестовое CRM</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Label</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pages}" var="page">
                <tr>
                    <td><c:out value="${page.title}"/></td>
                    <td><c:out value="${page.description}"/></td>
                    <td><a href="<c:url value='/content/${page.id}'/>">${page.menuLabel}</a></td>
                    <td><a href="<c:url value='/edit/${page.id}'/>">Edit page</a></td>
                    <td><a href="<c:url value='/pages/delete/${page.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>