package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "phongdat")
@Data
@Builder
public class PhongDat {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private long tienCoc;
	
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
	@OneToMany(mappedBy = "phongDat")
	private List<ChiTietDichVu> danhSachChiTietDichVu;
	
	@ManyToOne
	@JoinColumn(name = "lanDat_id")
	private LanDat lanDat;
	
	@OneToOne
	@JoinColumn(name = "hoaDon_id")
	private HoaDon hoaDon;
}
