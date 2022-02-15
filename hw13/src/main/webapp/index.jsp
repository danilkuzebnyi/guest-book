<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="task1.GuestBook" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.concurrent.ConcurrentSkipListMap" %>

<%
    @SuppressWarnings("unchecked")
    ConcurrentSkipListMap<LocalDateTime, GuestBook> guestBooks =
            (ConcurrentSkipListMap<LocalDateTime, GuestBook>) session.getAttribute("books");
    session.setAttribute("guestBooks", guestBooks);
%>

<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Guest Book</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<h1>Guest Book</h1>
<form action="guest-book" method="post">
    <p>
        <input class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="name" placeholder="name"><br>
    </p>
    <p>
        <textarea class="w3-input w3-animate-input w3-border w3-round-large" name="message" placeholder="message..."></textarea>
    </p>
    <p><select class="w3-select" size="6" name="rating">
        <option disabled>Choose the book</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select></p>
    <button class="w3-btn w3-hover-green w3-round-large">Submit</button>
</form>

<p>
<table border="1">
    <caption>
        Guest Books
    </caption>
    <c:if test="${guestBooks.size() != 0}">
        <tr class="w3-red">
            <th>name</th>
            <th>message</th>
            <th>rating</th>
        </tr>
        <c:forEach var="book" items="${guestBooks.values()}}" varStatus="bookStatus">
            <tr>
                <td> <c:out value="${bookStatus.count}" /> </td>
                <td><c:out value="${book}" /></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</p>
</body>
</html>
