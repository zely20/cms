<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title>Page</title>
</head>
<body>
<div class="container mt-3">
    <form name='login' action="<c:url value='/pages/save'/>" method='POST'>
        <h2>Title</h2>
        <td><input type="text" name="title"></td>
        <h2>Description</h2>
        <td><input type="text" name="description"></td>
        <h2>Slug</h2>
        <td><input type="text" name="slug"></td>
        <h2>Menu label</h2>
        <td><input type="text" name="menuLabel"></td>
        <h2>H1</h2>
        <td><input type="text" name="h1"></td>
        <h3>Content</h3>
        <p><textarea rows="10" cols="75" name="content"></textarea></p>
        <h2>Published At</h2>
        <td><input type="date" name="publishedAt"></td>
        <h2>Priority</h2>
        <td><input type="text" name="priority"></td>
        <td colspan='2'><input name="submit" type="submit" value="submit" class="btn btn-primary"/></td>
    </form>
</div>
</body>
</html>
