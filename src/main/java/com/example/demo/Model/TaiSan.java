package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "taisan")
public class TaiSan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	
	@Column
	private String tenTaiSan;
	
	@Column
	private long donGia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taiSan")
	private List<ChiTietTaiSan> danhSachTaiSan;
	
	@OneToMany(mappedBy = "taiSan")
	private List<Anh> danhSachAnh;
	
}
