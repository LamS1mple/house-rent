package com.example.demo.Model;

import java.sql.Date;
import java.util.List;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "landat")
public class LanDat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date ngayDat;
	
	@Column
	private boolean trangThai;
	
	@OneToMany(mappedBy = "lanDat")
	private List<PhongDat> danhSachPhongDat;
	
	
	@ManyToOne
	@JoinColumn(name = "khachHang_id")
	private KhachHang khachHang;
	
	@OneToOne(mappedBy = "lanDat")
	private HopDong hopDong;
	
}
