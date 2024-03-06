package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Phong {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String tenPhong;
	
	@Column
	private long donGiaPhong;
		
	@Column
	private boolean trangThai;
	
	@OneToMany(mappedBy = "phong")
	private List<ChiTietTaiSan> danhSachTaiSan;
	
	@OneToMany(mappedBy = "phong")
	private List<PhongDat> danhsachPhongDat;
}
