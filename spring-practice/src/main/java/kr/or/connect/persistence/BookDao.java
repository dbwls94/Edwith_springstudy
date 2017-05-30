package kr.or.connect.persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.connect.domain.Book;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Repository //spring에서 component scan 대상이라는 의미
public class BookDao {
	private NamedParameterJdbcTemplate jdbc;

	
	/*public BookDao(DriverManagerDataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}*/
	
	//BookDao가 외부에서 주입된 DataSource에 의존 -> 직접 DataSource 객체생성 안해서 변경하지 않아도 되는 구조
	public BookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final String COUNT_BOOK = "SELECT COUNT(*) FROM book";
	public int countBooks() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
	}
	
	private static final String SELECT_BY_ID = "SELECT id, title, author, pages FROM book where id = :id";
	public Book selectById(Integer id) {
		RowMapper<Book> rowMapper = (rs, i) -> { //rs -> ResultSet
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPages((Integer) rs.getObject("pages"));
			return book;
		};

		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
}
