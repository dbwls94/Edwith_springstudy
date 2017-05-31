package kr.or.connect.service;

import java.util.Arrays;
import java.util.Collection;

import kr.or.connect.domain.Book;

import org.springframework.stereotype.Service;

//@Controller -> @Service -> @Repository
@Service //Spring에서 component scan의 대상으로 인지됨
public class BookService {
	public Book findById(Integer id) {
		return new Book(1, "Java 이렇게 공부하자", "김자바", 300);
	}

	public Collection<Book> findAll() {
		return Arrays.asList(
			new Book(1, "네이버 네비 좋아요", "김광근", 300),
			new Book(2, "HTTP 완벽 이해하기", "김명호", 300)
		);
	}
}
