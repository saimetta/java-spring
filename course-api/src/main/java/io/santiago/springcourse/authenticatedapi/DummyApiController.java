package io.santiago.springcourse.authenticatedapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DummyApiController {

	@GetMapping("/")
	public CustomResponse home() {
		return CustomResponse.builder().message("Home").build();
	}
	
	@GetMapping("/user")
	public CustomResponse user() {
		return CustomResponse.builder().message("User").build();
	}
	
	@GetMapping("/admin")
	public CustomResponse admin() {
		return CustomResponse.builder().message("Admin").build();
	}
}
