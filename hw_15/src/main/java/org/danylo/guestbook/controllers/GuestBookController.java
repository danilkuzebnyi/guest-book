package org.danylo.guestbook.controllers;

import org.danylo.guestbook.models.GuestBook;
import org.danylo.guestbook.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
    private final GuestBookRepository bookRepository;
    private List<GuestBook> books;

    @Autowired
    public GuestBookController(GuestBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        books = bookRepository.getBooks();
    }

    @GetMapping("/pagination")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                             @RequestParam(value = "itemsPerPage", required = false, defaultValue = "2") int itemsPerPage) {
        int booksPages = (int) Math.ceil((double) books.size() / itemsPerPage);
        List<GuestBook> splittedBooks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < booksPages; i++) {
            if (page == i) {
                splittedBooks = books.stream().
                        sorted(new GuestBookComparator()).
                        skip((long) i * itemsPerPage).
                        limit(itemsPerPage).
                        collect(Collectors.toList());
            }
        }
        return new ModelAndView("pagination")
                .addObject("currentPage", page)
                .addObject("itemsPerPage", itemsPerPage)
                .addObject("books", splittedBooks)
                .addObject("booksElements", books.size())
                .addObject("booksPages", booksPages);
    }

    @GetMapping()
    public ModelAndView newBook(@ModelAttribute("book") GuestBook book) {
        return new ModelAndView("representBooks")
                .addObject("books", books.stream().
                        sorted(new GuestBookComparator()).
                        collect(Collectors.toList()))
                .addObject("booksSize", books.size());
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") GuestBook book) {
        books.add(book);
        return "redirect:/guest-book";
    }
}
