package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.KhachHang;
import com.example.demo.Model.QuanLy;
import com.example.demo.Service.KhachHangService;
import com.example.demo.Service.QuanLyService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value = "*")
public class AccountController {

	
	@Autowired
	private QuanLyService quanLyService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@PostMapping("/sign-up-quan-ly")
	public String createAcount(@RequestBody QuanLy quanLy) {
		
		return quanLyService.createQuanLy(quanLy);
	}
	
	@PostMapping("/sign-up-khach-hang")
	public String createAcount(@RequestBody KhachHang khachHang , HttpSession session) {
		return khachHangService.createKhachHang(khachHang);
	}
	
	@PostMapping("/login-quan-ly")
	public QuanLy checkAccount(@RequestBody QuanLy quanLy, HttpSession session){
		return quanLyService.checkAccount(quanLy, session);
	}
	
	@PostMapping("/login-in-khach-hang")
	public String loginAcount(@RequestBody KhachHang khachHang
			, HttpSession session) {
		KhachHang checkKhachHang = khachHangService.checkAcount(khachHang);
		if (checkKhachHang == null) {
			return "loi";
		}
		session.setAttribute("khachHang", checkKhachHang);
		return "thanh cong";
	}
	
	
}
