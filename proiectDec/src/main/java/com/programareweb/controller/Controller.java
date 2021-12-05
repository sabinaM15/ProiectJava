package com.programareweb.controller;

import com.programareweb.entity.Book;
import com.programareweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/new")
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PostMapping("/new/add-book")
    public String addBook( Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookRepository.save(book);
        return "redirect:/index";
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Book findBook(@PathVariable int id) {
        return bookRepository.findBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }


}
