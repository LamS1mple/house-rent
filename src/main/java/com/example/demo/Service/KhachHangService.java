package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.KhachHang;
import com.example.demo.Reponsitory.KhachHangReponsitory;

@Service
public class KhachHangService {
	
	@Autowired
	private KhachHangReponsitory khachHangReponsitory;
	
	public String createKhachHang(KhachHang khachHang) {
		
		khachHangReponsitory.save(khachHang);
		return "thanh cong";
	}
	
	public KhachHang checkAcount(KhachHang khachHang) {
		return  khachHangReponsitory.findByTaiKhoanAndMatKhau(khachHang.getTaiKhoan(), khachHang.getMatKhau());
	}

}
