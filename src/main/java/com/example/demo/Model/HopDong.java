package com.example.demo.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HopDong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(
			name = "lanDat_id"
			)
	private LanDat lanDat;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayThanhToan;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayHetHan;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date ngayBatDau;

}
