package com.example.demo.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "hoadon")
public class HoaDon {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date ngayThanhToan;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date ngayLenHoaDon;
	
	@OneToOne(mappedBy = "hoaDon")
	private PhongDat phongDat;
	

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	

	
	
	
}
