package kr.or.connect.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//이 클래스는 웹요청을 처리하는 클래스
@RestController //spring의 ApplicationContext에 등록됨
public class HelloController {
	@GetMapping("/hello") //요청을 처리할 주소를 알려줌
	String hello(){
		System.out.println("in hello()");
		return  "Hello World"; //반환값은 api 결과값
	}
}