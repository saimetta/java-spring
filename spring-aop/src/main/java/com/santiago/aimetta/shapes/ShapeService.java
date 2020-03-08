package com.santiago.aimetta.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {
	
	@Autowired
	private Circle circle;
	@Autowired
	private Triangle triangle;
	
	public Circle getCircle() {
		circle.setName("Circle");
		return circle;
	}
	public Triangle getTriangle() {
		triangle.setName("Triangle");
		return triangle;
	}
	
	

}
