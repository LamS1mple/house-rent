package com.example.demo.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "chitietdichvu")
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private long soLuongCu;
	
	@Column
	private long soLuongMoi;
	
	@JsonFormat(pattern = "dd/MM/yyyy 00:00")
	private Date ngayBatDau;
	@JsonFormat(pattern = "dd/MM/yyyy 23:59")
	private Date ngayKetThuc;
	
	@ManyToOne
	@JoinColumn(name = "dichVu_id")
	private DichVu dichVu;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "phongDat_id")
	private PhongDat phongDat;
	
	
}
