package com.example.demo.data.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ApiResponse {

	private int code;
	private Object result;
	
	
}
