package com.example.demo.data.response;

import java.util.List;

import com.example.demo.Model.Anh;
import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.PhongDat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhongRe{
		long id;
		String tenPhong;
		
		
		long donGiaPhong;
			
		
		 boolean trangThai;
		
		
		 String thongTinPhong;
		
		
		 String diaChi;
		
		 List<ChiTietTaiSan> danhSachTaiSan;
		
		 List<PhongDat> danhsachPhongDat;
		
		
		 List < String > danhSachAnh;
		 


}
