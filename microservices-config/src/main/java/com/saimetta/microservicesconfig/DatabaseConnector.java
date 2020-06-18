package com.saimetta.microservicesconfig;

public interface DatabaseConnector {
	String connect(DbSettings dbSettings);
}
