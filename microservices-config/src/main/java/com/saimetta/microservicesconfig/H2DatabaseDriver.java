package com.saimetta.microservicesconfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("default")
@Component
public class H2DatabaseDriver implements DatabaseConnector {

	@Override
	public String connect(DbSettings dbSettings) {
		return String.format("H2 connection established, host: %s, port: %s", dbSettings.getHost(), dbSettings.getPort());
	}

}
