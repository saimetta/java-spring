package com.saimetta.microservicesconfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("test")
@Component
public class MYSQLDatabaseDriver implements DatabaseConnector{

	@Override
	public String connect(DbSettings dbSettings) {
		return String.format("MYSQL connection established, host: %s, port: %s", dbSettings.getHost(), dbSettings.getPort());
	}
}
