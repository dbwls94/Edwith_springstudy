package kr.or.connect;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan //Component scan을 사용하겠다 -> 속성이 없으면 해당 패키지와 그 하위패키지에서 bean등록 대상 클래스를 찾음 -> BookDao
@Configuration //ApplicationContext에서 관리할 대상 객체라는걸 알림
@PropertySource("application.properties") //파일의 속성을 AppConfig의 멤버변수로 불러옴
public class AppConfig {
	/*@Bean //ApplicationContext에 등록될 객체를 반환하는 객체에 붙임
	public DataSource dataSource() {
		//BookLauncher의 DataSource 생성 역할을 ApplicationContext에 맡김
 		BasicDataSource dataSource = new BasicDataSource(); 
 		dataSource.setDriverClassName("org.h2.Driver");
 		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
 		dataSource.setUsername("sa");
 		dataSource.setPassword("sa");
 		return dataSource;
 	}*/
	
	//파일에서 값을 참조해온다
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}