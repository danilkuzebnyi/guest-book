package task1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    public Map<LocalDateTime, GuestBook> books = new TreeMap<>(Collections.reverseOrder());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String rating = request.getParameter("rating");
        GuestBook book = new GuestBook(name, message, rating);
        LocalDateTime date = LocalDateTime.now();
        books.put(date, book);
        request.setAttribute("books", books);
        request.getRequestDispatcher("/").forward(request, response);
    }
}
