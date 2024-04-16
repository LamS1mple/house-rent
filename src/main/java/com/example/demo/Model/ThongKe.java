package com.example.demo.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ThongKe extends HoaDon{

	public	ThongKe(long id, Date ngayThanhToan, Date ngayLenHoaDon, PhongDat phongDat) {
		super(id, ngayThanhToan, ngayLenHoaDon, phongDat);
	}

	@Transient
	private long tongTien;
	
	@JsonProperty("tongTien")
	private long getTongTien() {
		
		long tongDichVu = 0;
		for (int i = 0  ; i < phongDat.getDanhSachChiTietDichVu().size() ; i ++) {
			ChiTietDichVu chiTietDichVu = phongDat.getDanhSachChiTietDichVu().get(i);
			tongDichVu += (chiTietDichVu.getSoLuongMoi() - chiTietDichVu.getSoLuongCu()) * chiTietDichVu.getDichVu().getDonGia();
		}
		tongDichVu += phongDat.getPhong().getDonGiaPhong();
		return tongDichVu;
	}}
