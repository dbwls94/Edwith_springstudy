package kr.or.connect.persistence;

//import kr.or.connect.AppConfig;
import java.util.List;

import kr.or.connect.domain.Book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;



//밑에 is(), assertThat()를 위해서...
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*; 

@RunWith(SpringRunner.class) //테스트전에 spring의 ApplicationContext를 로딩
//@ContextConfiguration(classes = AppConfig.class) //ApplicationContext에 등록된 bean을 지정한 설정파일이나 클래스를 지정
@SpringBootTest //Spring Boot 통해 설정한 ApplicationContext에서 BookDao를 참조
@Transactional //테스트 메소드가 실행이 끝나는 시점에서 트랜잭션 롤백
public class BookDaoTest {
	@Autowired //AppConfig에 정의된 BookDao를 참조 
	private BookDao dao;
	
	//BookDao의 countBooks() 테스트
	@Test
	public void shouldCount() {
		int count = dao.countBooks();
		System.out.println(count);
	}
	
	//insert 후 생성된 id로 select되는지 확인
	@Test
	public void shouldInsertAndSelect() {
		// given
		Book book = new Book("Java 웹개발", "네이버", 342);

		// when
		Integer id = dao.insert(book);

		// then
		Book selected = dao.selectById(id);
		System.out.println(selected);
		assertThat(selected.getTitle(), is("Java 웹개발"));
	}
	
	@Test
	public void shouldDelete() {
		// given
		Book book = new Book("네이버 자바", "네이버", 142);
		Integer id = dao.insert(book);

		// when
		int affected = dao.deleteById(id);

		// Then
		assertThat(affected, is(1));
	}
	
	@Test
	public void shouldUpdate() {
		// Given
		Book book = new Book("네이버 자바", "네이버", 142);
		Integer id = dao.insert(book);

		// When
		book.setId(id);
		book.setTitle("네이버 자바2");
		int affected = dao.update(book);

		// Then
		assertThat(affected, is(1));
		Book updated = dao.selectById(id);
		assertThat(updated.getTitle(), is("네이버 자바2"));
	}
	
	@Test
	public void shouldSelectAll() {
		List<Book> allBooks = dao.selectAll();
		assertThat(allBooks, is(notNullValue()));
	}
}
