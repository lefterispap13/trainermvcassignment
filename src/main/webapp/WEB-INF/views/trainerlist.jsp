
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainers' List</title>
    </head>
    <body>
        <div align="center">
        <h1>Trainers' List</h1>
        <a href="/new">Register New Trainer</a>
        <table border="1" cellpadding="10">
		<tr>
                    <td>ID</td><td>FIRST NAME</td><td>LAST NAME</td><td>SUBJECT</td><td></td>
		</tr>
		<c:forEach items="${trainers}" var="trainer">
			<tr>
                            
                            <td><a href="<c:url value='${editurl}/${trainer.id}' />">${trainer.id}</a></td>
                            <td>${trainer.firstName}</td>
                            <td>${trainer.lastName}</td>
                            <td>${trainer.subject}</td>
                            <td><a href="<c:url value='${deleteurl}/${trainer.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
        <div id="msg">${msg}</div>
        </div>
    </body>
</html>
