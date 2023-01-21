package com.amankr8.bookexchange.controller;

import com.amankr8.bookexchange.entity.Book;
import com.amankr8.bookexchange.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/library")
    public ModelAndView listBooks() {
        ModelAndView mav = new ModelAndView("library");
        List<Book> bookList = bookRepository.findAll();
        mav.addObject("books", bookList);
        return mav;
    }

    @GetMapping("/add-book-form")
    public ModelAndView addBookForm() {
        ModelAndView mav = new ModelAndView("add-book-form");
        Book newBook = new Book();
        mav.addObject("book", newBook);
        return mav;
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/library";
    }

    @GetMapping("/show-update-form")
    public ModelAndView showUpdateForm(@RequestParam Long bookId) {
        ModelAndView mav = new ModelAndView("add-book-form");
        Book book = bookRepository.findById(bookId).get();
        mav.addObject("book", book);
        return mav;
    }

    @GetMapping("/delete-book")
    public String deleteBook(@RequestParam Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/library";
    }
}
