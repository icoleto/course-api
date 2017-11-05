package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHi() {
		return "H i";
	}
	
	
	
	@RequestMapping("/getSumTwoNumbers")
	public String getSumTwoNumbers(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2 ) {
		return String.valueOf(num1 + num2);
	}
}
