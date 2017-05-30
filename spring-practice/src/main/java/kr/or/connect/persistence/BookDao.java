package kr.or.connect.persistence;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
}
