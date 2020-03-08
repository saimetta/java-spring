package com.santiago.aimetta.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShapeController {
	
		@Autowired
	private ShapeService service;
	
	@GetMapping(path = "/circle")
	public String getCircle() {
		return service.getCircle().getName();
	}

	@GetMapping(path = "/triangle")
	public String getTriangle() {
		Triangle tri = service.getTriangle();
		tri.throwRuntime();
		tri.setNameAndReturn("Triangulini");
		return service.getTriangle().getName();
	}

}
