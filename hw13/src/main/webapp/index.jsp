<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="task1.GuestBook" %>
<%@ page import="java.time.LocalDateTime" %>

<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Guest Book</title>
</head>
<body>
<h1>Guest Book</h1>
<form action="first" method="post">
    <p>
        <input type="text" name="name" placeholder="name"><br>
    </p>
    <p>
        <textarea name="message" placeholder="message..."></textarea>
    </p>
    <p><select size="6" multiple name="rating">
        <option disabled>Choose the book</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select></p>
    <button>Submit</button>
</form>
<%
    @SuppressWarnings("unchecked")
    Map<LocalDateTime, GuestBook> guestBooks = (Map<LocalDateTime, GuestBook>) request.getAttribute("books");
    request.setAttribute("guestBooks", guestBooks);
%>

<p>
<table>
    <caption>
        Guest Books
    </caption>
    <c:if test="${guestBooks.size() != 0}">
        <tr>
            <th>name</th>
            <th>message</th>
            <th>rating</th>
        </tr>
        <c:forEach var="guestBook" items="${guestBooks.values()}}">
            <tr>
                <td><c:out value="${guestBook}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</p>
</body>
</html>
