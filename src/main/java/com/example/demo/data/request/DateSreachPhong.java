package com.example.demo.data.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DateSreachPhong {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ngayBatDau;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ngayKetThuc;
}
