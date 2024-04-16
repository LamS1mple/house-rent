package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Phong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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

	@JsonProperty("danhSachTaiSan")
	public List<ChiTietTaiSan> getDanhSachTaiSan() {
		return danhSachTaiSan;
	}
	

	public List<PhongDat> getDanhsachPhongDat() {
		return danhsachPhongDat;
	}

	public void setDanhsachPhongDat(List<PhongDat> danhsachPhongDat) {
		this.danhsachPhongDat = danhsachPhongDat;
	}

	public List<Anh> getDanhSachAnh() {
		return danhSachAnh;
	}

	public void setDanhSachAnh(List<Anh> danhSachAnh) {
		this.danhSachAnh = danhSachAnh;
	}
	
	
}
