package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phongdat")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhongDat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	
	@Column
	private long tienCoc;
	
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
	@OneToMany(mappedBy = "phongDat")
	private List<ChiTietDichVu> danhSachChiTietDichVu;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "lanDat_id")
	private LanDat lanDat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "phongDat")
	private List<HoaDon> hoaDon;
}
