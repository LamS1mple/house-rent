package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.QuanLyExp;
import com.example.demo.Model.QuanLy;
import com.example.demo.Reponsitory.QuanLyReponsitory;

import jakarta.servlet.http.HttpSession;

@Service
public class QuanLyService {

	@Autowired
	private QuanLyReponsitory quanLyReponsitory;
	
	public String createQuanLy(QuanLy quanLy) {
		QuanLy checkExits = quanLyReponsitory.findByTaiKhoanAndMatKhau(quanLy.getTaiKhoan(), quanLy.getMatKhau());
		if (checkExits != null) {
			throw new QuanLyExp("Account is exits");
		}
		else {
			quanLyReponsitory.save(quanLy);
			return "Thanh cong"; 
		}
		
	}
	
	public QuanLy checkAccount(QuanLy quanLy, HttpSession session){
		quanLy = quanLyReponsitory.findByTaiKhoanAndMatKhau(quanLy.getTaiKhoan(), quanLy.getMatKhau());
		if (quanLy == null) {
			throw new QuanLyExp("Account is not exits");
		}
		else {
			session.setAttribute("quan-ly", quanLy);
			return quanLy;
		}
		
	}
	
	
}
