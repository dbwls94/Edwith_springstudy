package kr.or.connect;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.connect.domain.Book;
import kr.or.connect.persistence.BookDao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

//BookLauncer에 DataSource를 주입
public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. DB connection
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");*/
		
		//2. DriverManagerDataSource -> BasicDataSource로 교체
		/*BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");*/
		
		//1. NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
		//String sql = "SELECT COUNT(*) FROM book";
		//Map<String, Object> params = Collections.emptyMap(); //쿼리에 파라미터가 없으므로 빈 Map을 넘겨줌
		//Integer count = jdbc.queryForObject(sql, params, Integer.class); 
		
		//2. DAO 추출 -> BookDao.java
		/*BookDao dao = new BookDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);*/
		
		//3. AppConfig에서 생성된 객체는 ApplicationContext를 거쳐 BookLauncher에서 참조
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//4. BookDao를 직접 ApplicationContext에서 얻어옴
		//DataSource dataSource = context.getBean(DataSource.class);
		//BookDao dao = new BookDao(dataSource);
		BookDao dao = context.getBean(BookDao.class);
		
		int count = dao.countBooks();
		System.out.println(count);
		
		//Book id가 1인 Book 조회
		Book book = dao.selectById(1);
		System.out.println(book);
		
		context.close();
	}

}
