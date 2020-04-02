package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private  List<Book> books = new ArrayList<>();

    @RequestMapping({ "/", "" })
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String booksList(Model model) {
        // code to get books and enrich model with those books\

       // books.add(new Book("name", "1234", "author"));
       model.addAttribute("books", books);
         return "form-controller-get";
    }
    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book1, Model model) {
    // code to save new book
        books.add(book1);
        model.addAttribute("books", book1);
        
     return "redirect:/books-list";
     }




}

