package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

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
	
	@Column
	private String thongTinPhong;
	
	@Column
	private String diaChi;
	@JsonIgnore
	@OneToMany(mappedBy = "phong")
	private List<ChiTietTaiSan> danhSachTaiSan;
	@JsonIgnore
	@OneToMany(mappedBy = "phong")
	private List<PhongDat> danhsachPhongDat;
	
	@OneToMany(mappedBy = "phong")
	private List<Anh> danhSachAnh;
}
