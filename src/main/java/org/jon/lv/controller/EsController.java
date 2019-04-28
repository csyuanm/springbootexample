package org.jon.lv.controller;

import java.util.List;

import org.jon.lv.es.Book;
import org.jon.lv.es.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class EsController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/queryAll")
	public Iterable<Book> queryAll() {
		Iterable<Book> ret = bookService.findAll();
		System.out.println(bookService.findAll());
		System.out.println("查找结束");
		return bookService.findAll();
	}
	
	@RequestMapping("/queryById")
	public String queryOne(String id) {
		bookService.findOne(id);
		return "";
	}
	
	@RequestMapping("/author")
	public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
		Page<Book> result = bookService.findByAuthor(author, pageRequest);
        return result;
    }
	
	@RequestMapping("/saveOne")
	public String saveOne(@RequestBody Book book) {
		bookService.save(book);
		return "aa";
	}

	@RequestMapping("/title")
    public List<Book> findByTitle(String title) {
    	List<Book> ret = bookService.findByTitle(title);
        return ret;
    }

}
