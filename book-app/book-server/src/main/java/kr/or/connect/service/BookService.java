package kr.or.connect.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import kr.or.connect.domain.Book;

import org.springframework.stereotype.Service;

//@Controller -> @Service -> @Repository
@Service //Spring에서 component scan의 대상으로 인지됨
public class BookService {
	private ConcurrentMap<Integer, Book> repo = new ConcurrentHashMap<>();
	private AtomicInteger maxId = new AtomicInteger(0);
	
	/*public Book findById(Integer id) {
		return new Book(1, "Java 이렇게 공부하자", "김자바", 300);
	}

	public Collection<Book> findAll() {
		return Arrays.asList(
			new Book(1, "네이버 네비 좋아요", "김광근", 300),
			new Book(2, "HTTP 완벽 이해하기", "김명호", 300)
		);
	}*/
	
	public Book findById(Integer id) {
		return repo.get(id);
	}

	public Collection<Book> findAll() {
		return repo.values();
	}

	//Book 객체 저장
	public Book create(Book book) {
		Integer id = maxId.addAndGet(1);
		book.setId(id);
		repo.put(id, book);
		return book;
	}
	
	public boolean update(Book book) {
		Book old = repo.put(book.getId(), book);
		return old != null;
	}
	
	public boolean delete(Integer id) {
		Book old = repo.remove(id);
		return old != null;
	}
}
