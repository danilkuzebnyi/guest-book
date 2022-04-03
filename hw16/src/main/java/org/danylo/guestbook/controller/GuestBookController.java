package org.danylo.guestbook.controller;

import org.danylo.guestbook.model.GuestBook;
import org.danylo.guestbook.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
    private final GuestBookRepository bookRepository;
    private List<GuestBook> books;

    @Autowired
    public GuestBookController(GuestBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        books = bookRepository.showAll();
    }

    @GetMapping("/pagination")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                             @RequestParam(value = "itemsPerPage", required = false, defaultValue = "2") int itemsPerPage) {
        int booksPages = (int) Math.ceil((double) books.size() / itemsPerPage);
        List<GuestBook> splittedBooks = bookRepository.paginate(page, itemsPerPage, booksPages);

        return new ModelAndView("pagination")
                .addObject("currentPage", page)
                .addObject("itemsPerPage", itemsPerPage)
                .addObject("books", splittedBooks)
                .addObject("booksElements", books.size())
                .addObject("booksPages", booksPages);
    }

    @GetMapping()
    public ModelAndView newBook(@ModelAttribute("book") GuestBook book) {
        books = bookRepository.showAll();
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
