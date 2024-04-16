package com.example.demo.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.Exp;
import com.example.demo.Model.Anh;
import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.Phong;
import com.example.demo.Reponsitory.ChiTietTaiSanReponsitory;
import com.example.demo.Reponsitory.PhongReponsitory;
import com.example.demo.Reponsitory.TaiSanReponsitory;
import com.example.demo.data.response.ApiResponse;
import com.example.demo.data.response.PhongRe;


@Service
public class PhongService {

	@Autowired
	private PhongReponsitory phongReponsitory;
	
	@Autowired 
	private ChiTietTaiSanReponsitory chiTietTaiSanReponsitory;
	
	@Autowired
	private TaiSanReponsitory taiSanReponsitory;
	
	@Value("${image.house}")
	private String  duongDan;
	
	public List<PhongRe> getAllPhong(){
		List<Phong> listPhong = phongReponsitory.findAll();
		List<PhongRe> lPhongRes = new ArrayList<>();
		for (Phong iPhong : listPhong) {
		
			List< Anh > dAnhs = new ArrayList<Anh>();
//			for (Anh anh : iPhong.getDanhSachAnh()) {
//				String dirString = duongDan + anh.getAnh();
//				
//				
//			}
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
	
	public List<PhongRe> getAllPhongEmpty(){
		List<Phong> listPhong = phongReponsitory.findByTrangThai(false);
		List<PhongRe> lPhongRes = new ArrayList<>();
		for (Phong iPhong : listPhong) {
		
			List< Anh > dAnhs = new ArrayList<Anh>();
//			for (Anh anh : iPhong.getDanhSachAnh()) {
//				String dirString = duongDan + anh.getAnh();
//				
//				
//			}
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

	public ApiResponse getPhongById(long idPhong) {
		Optional<Phong> phong = phongReponsitory.findById(idPhong);
		if (phong.isEmpty()) {
			throw new Exp("No exit Phong is "+ idPhong );
		}
		Phong phongId = phong.get();
		
		List<ChiTietTaiSan> listTaiSan = chiTietTaiSanReponsitory.findByPhong(phongId);


		
		phongId.setDanhSachTaiSan(listTaiSan);
		PhongRe re = PhongRe.builder()
				.diaChi(phongId.getDiaChi())
				.danhSachAnh(phongId.getDanhSachAnh())
				.danhSachTaiSan(listTaiSan)
				.id(phongId.getId())
				.tenPhong(phongId.getTenPhong())
				.thongTinPhong(phongId.getThongTinPhong())
				.trangThai(phongId.isTrangThai())
				.donGiaPhong(phongId.getDonGiaPhong())
				.build();
//		System.out.println(phongId.toString());
		return ApiResponse.builder().code(1000).result(re).build();
	}
	
	public List<Phong> getPhongChon(List<Long> idDanhPhongChon){
		return phongReponsitory.findAllById(idDanhPhongChon).stream()
				.filter((item) -> !item.isTrangThai()).toList();
	}
}
