package kr.or.connect.presentation;

import java.util.Collection;

import kr.or.connect.domain.Book;
import kr.or.connect.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Book create(@RequestBody Book book) {
		return service.create(book);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable Integer id, @RequestBody Book book) {
		book.setId(id);
		service.update(book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
