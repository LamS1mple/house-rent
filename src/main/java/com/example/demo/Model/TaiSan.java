package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "taisan")
public class TaiSan {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String tenTaiSan;
	
	@Column
	private long donGia;
	
	@OneToMany(mappedBy = "taiSan")
	private List<ChiTietTaiSan> danhSachTaiSan;
	
	
}
