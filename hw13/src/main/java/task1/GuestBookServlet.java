package task1;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

@WebServlet("/guest-book")
public class GuestBookServlet extends HttpServlet {
    private Map<LocalDateTime, GuestBook> books = new ConcurrentSkipListMap<>(Collections.reverseOrder());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>" +
                                        "<a href = '/'> Back to main page" +
                                     "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String rating = request.getParameter("rating");
        GuestBook book = new GuestBook(name, message, rating);
        LocalDateTime date = LocalDateTime.now();
        books.put(date, book);
        session.setAttribute("books", books);
        response.sendRedirect("/");
    }
}
