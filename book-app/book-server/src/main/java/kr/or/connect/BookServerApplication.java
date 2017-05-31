package kr.or.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//이렇게 대신 이 파일 패키지를 한단계 위로 올림
//@ComponentScan(basePackages = "kr.or.connect.presentation") //현재 kr.or.connect.bookserver 패키지의 하위패키지가 kr.or.connect.presentation이 아니어서 못찾음
//@ComponentScan(basePackages = "kr.or.connect.service")
public class BookServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}
}
