package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "chitietdichvu")
public class ChiTietDichVu {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private long soLuongCu;
	
	@Column
	private long soLuongMoi;
	
	@ManyToOne
	@JoinColumn(name = "dichVu_id")
	private DichVu dichVu;
	
	@ManyToOne
	@JoinColumn(name = "phongDat_id")
	private PhongDat phongDat;
	
	
}
