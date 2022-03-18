package org.danylo.guestbook.controllers;

import org.danylo.guestbook.models.GuestBook;
import org.danylo.guestbook.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
    GuestBookRepository bookRepository;
    List<GuestBook> books;

    @Autowired
    public GuestBookController(GuestBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/pagination")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                             @RequestParam(value = "itemsPerPage", required = false, defaultValue = "2") int itemsPerPage) {
        Page<GuestBook> books = bookRepository.findAll(PageRequest.of(page, itemsPerPage, Sort.by("id").descending()));
        return new ModelAndView("pagination")
                .addObject("currentPage", page)
                .addObject("itemsPerPage", itemsPerPage)
                .addObject("books", books)
                .addObject("booksElements", books.getTotalElements())
                .addObject("booksPages", books.getTotalPages());
    }

    @GetMapping()
    public ModelAndView newBook(@ModelAttribute("book") GuestBook book) {
        books = bookRepository.findAll();
        return new ModelAndView("representBooks")
                .addObject("books", books)
                .addObject("booksSize", books.size());
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") GuestBook book) {
        bookRepository.save(book);
        return "redirect:/guest-book";
    }
}
