package kr.or.connect;

import java.util.Collections;
import java.util.Map;

import kr.or.connect.persistence.BookDao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

//BookLauncer에 DataSource를 주입
public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DB connection
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");*/
		
		//DriverManagerDataSource -> BasicDataSource로 교체
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		//NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
		//String sql = "SELECT COUNT(*) FROM book";
		//Map<String, Object> params = Collections.emptyMap(); //쿼리에 파라미터가 없으므로 빈 Map을 넘겨줌
		//Integer count = jdbc.queryForObject(sql, params, Integer.class); 
		
		//DAO 추출 -> BookDao.java
		BookDao dao = new BookDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);
	}

}
