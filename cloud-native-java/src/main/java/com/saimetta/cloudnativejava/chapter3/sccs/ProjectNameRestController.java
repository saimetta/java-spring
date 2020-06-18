package com.saimetta.cloudnativejava.chapter3.sccs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProjectNameRestController {

	private final String projectName;
	
	@Autowired
	public ProjectNameRestController(@Value("${configuration.projectName}") String projectName) {
		this.projectName = projectName;
	}
	
	@RequestMapping("/project-name")
	String projectName() {
		return this.projectName;
	}
}
