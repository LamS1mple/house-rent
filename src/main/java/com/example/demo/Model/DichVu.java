package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "dichvu")
public class DichVu {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String tenPhong;
	
	@Column
	private long donGia;
	
	@OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
	private List<ChiTietDichVu> danhSachDichVu;
}
