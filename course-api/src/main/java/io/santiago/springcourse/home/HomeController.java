package io.santiago.springcourse.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String sayHi() {
		return "<h3>Welcome!</h3>";
	}
}
