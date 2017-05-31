package kr.or.connect.presentation;

import java.util.Collection;

import kr.or.connect.domain.Book;
import kr.or.connect.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books") //공통적인 부분
public class BookController {
	private final BookService service; //BookService를 주입받음

	@Autowired
	public BookController(BookService service) {
		this.service = service;
	}
	
	//요청이 들어올 주소
	//json으로 반환
	@GetMapping
	Collection<Book> readList() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	Book read(@PathVariable  Integer id) {
		return service.findById(id);
	}
}
