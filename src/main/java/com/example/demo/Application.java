package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Application {
	List<Book> books123=new ArrayList<>();
	private static BookService bookService;
	public static void main(String[] args) {
		ApplicationContext aplCont= SpringApplication.run(Application.class, args);
		bookService=aplCont.getBean(BookService.class);
		//bookService.createUser("2","2", "3");
		//bookService.createUser("1","2", "aa");
		//System.out.println(bookService.findByName("1"));
		//bookService.createUser("1","2", "3");

		//System.out.println(bookService.getAllUsers());
	}

	@RequestMapping(value = "/book/{id}")
	public String getBook(@PathVariable(value = "id")int id, Model model){
		Book b=bookService.getBookById(id);
		//bookService.createUser(b.getName(), b.getIbsn(), b.getAuthor());
		model.addAttribute("mybook", b);
		return "BookPage";
	}

	@RequestMapping(value = "/books-list", method = RequestMethod.GET)
	public String booksList(Model model) {

		// code to get books and enrich model with those books\

		model.addAttribute("books", bookService.getAllUsers());

		return "form-controller-get";
	}
	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String addNewBook(@ModelAttribute Book book1, Model model) {
		// code to save new book

		bookService.createUser(book1.getName(), book1.getIbsn(), book1.getAuthor());
		model.addAttribute("books", bookService.getAllUsers());


		//System.out.println(bookService.findByName("Andrey"));
		return "redirect:/books-list";
	}

}
