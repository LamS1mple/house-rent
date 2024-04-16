package com.example.demo.data.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateRequest {
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date ngayBatDau;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date ngayKetThuc;
}
