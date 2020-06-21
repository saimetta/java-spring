package io.santiago.springcourse.authenticatedapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomResponse {

	private String message;
	
}
