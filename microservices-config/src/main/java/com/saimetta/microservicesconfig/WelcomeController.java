package com.saimetta.microservicesconfig;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class WelcomeController {

	//Will work autowired
	private final DbSettings dbSettings;
	private final DatabaseConnector databaseConnector;
	private final Environment environment;
	
	public WelcomeController(DbSettings dbSettings,
			DatabaseConnector databaseConnector,
			Environment environment) {
		
		this.dbSettings = dbSettings;
		this.databaseConnector = databaseConnector;
		this.environment = environment;
	}
	
	@Value("${app.description}")
	private String welcomeMessage;
	
	@Value("static value")
	private String staticMessage;
	
	@Value("${doesnotexist: default value}")
	private String propertyWithDefault;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	//the #{} tells spring to evaluate the value
	@Value("#{${my.keyvaluespairs}}")
	private Map<String,String> userValues;
		
	@GetMapping("/welcome")
	public String welcome() {
		return welcomeMessage + " " + staticMessage + " " + propertyWithDefault + " " + listValues + " " + userValues;
	}
	
	@GetMapping("/dbsettings")
	public String dbSettings() {
		return dbSettings.toString();
	}
	
	@GetMapping("/dbconnect")
	public String dbConnect() {
		return databaseConnector.connect(dbSettings);
	}
	
	@GetMapping("/env")
	public String environment() {
		return environment.toString();
	}
	
}
 