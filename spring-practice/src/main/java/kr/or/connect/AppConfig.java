package kr.or.connect;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan //Component scan을 사용하겠다 -> 속성이 없으면 해당 패키지와 그 하위패키지에서 bean등록 대상 클래스를 찾음 -> BookDao
@Configuration //ApplicationContext에서 관리할 대상 객체라는걸 알림
public class AppConfig {
	@Bean //ApplicationContext에 등록될 객체를 반환하는 객체에 붙임
	public DataSource dataSource() {
		//BookLauncher의 DataSource 생성 역할을 ApplicationContext에 맡김
 		BasicDataSource dataSource = new BasicDataSource(); 
 		dataSource.setDriverClassName("org.h2.Driver");
 		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
 		dataSource.setUsername("sa");
 		dataSource.setPassword("sa");
 		return dataSource;
 	}
}