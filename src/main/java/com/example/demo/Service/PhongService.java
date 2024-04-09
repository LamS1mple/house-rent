package com.example.demo.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.Exp;
import com.example.demo.Model.Anh;
import com.example.demo.Model.Phong;
import com.example.demo.Reponsitory.PhongReponsitory;
import com.example.demo.data.response.PhongRe;


@Service
public class PhongService {

	@Autowired
	private PhongReponsitory phongReponsitory;
	
	@Value("${image.house}")
	private String  duongDan;
	
	public List<PhongRe> getAllPhong(){
		List<Phong> listPhong = phongReponsitory.findAll();
		List<PhongRe> lPhongRes = new ArrayList<>();
		for (Phong iPhong : listPhong) {
		
			List< String > dAnhs = new ArrayList<String>();
			for (Anh anh : iPhong.getDanhSachAnh()) {
				String dirString = duongDan + anh.getAnh();
				
				
			}
			lPhongRes.add(PhongRe.builder()
					.id(iPhong.getId())
					.donGiaPhong(iPhong.getDonGiaPhong())
					.diaChi(iPhong.getDiaChi())
					.trangThai(iPhong.isTrangThai())
					.thongTinPhong(iPhong.getThongTinPhong())
					.tenPhong(iPhong.getTenPhong())
					.donGiaPhong(iPhong.getDonGiaPhong())
					.danhSachAnh(dAnhs)
					.build());
		}
		return lPhongRes;
	}
	
	public List<Phong> getAllPhongEmpty(){
		List<Phong> listPhong = phongReponsitory.findByTrangThai(true);
		return listPhong;
	}

	public Phong getPhongById(long idPhong) {
		Optional<Phong> phong = phongReponsitory.findById(idPhong);
		if (phong.isEmpty()) {
			throw new Exp("No exit Phong is "+ idPhong );
		}
		return phong.get();
	}
}
