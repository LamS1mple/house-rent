package com.example.demo.data.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateRequest {
	@JsonProperty("isMonth")
	private boolean isMonth;

	private int nam;
	
	private int valueMonthQuerter;
}
