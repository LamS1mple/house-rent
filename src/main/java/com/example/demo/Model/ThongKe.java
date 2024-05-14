package com.example.demo.Model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ThongKe extends HoaDon{


	int idThongKe;
	
	private int thoigian;
	
	private long tongTien;
	
	public ThongKe(long id, Date ngayThanhToan, Date ngayLenHoaDon, PhongDat phongDat) {
		// TODO Auto-generated constructor stub
	}
	public ThongKe(long tongTien) {
		this.tongTien = tongTien;
	}
	public ThongKe(HoaDon hoaDon) {

		this.chiTietDichVuThang =  hoaDon.getChiTietDichVuThang();
		this.id = hoaDon.getId();
		this.ngayLenHoaDon = hoaDon.getNgayLenHoaDon();
		this.ngayThanhToan = hoaDon.getNgayThanhToan();
		this.phongDat = hoaDon.getPhongDat();
		
	}
	public ThongKe() {
		
		
	}
	public int getIdThongKe() {
		return idThongKe;
	}

	public void setIdThongKe(int idThongKe) {
		this.idThongKe = idThongKe;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}
	public int getThoigian() {
		return thoigian;
	}
	public void setThoigian(int thoigian) {
		this.thoigian = thoigian;
	}
	
	
}
