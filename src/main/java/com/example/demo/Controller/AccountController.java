package com.example.demo.Controller;

import java.net.http.HttpRequest;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.KhachHang;
import com.example.demo.Model.QuanLy;
import com.example.demo.Model.TaiSan;
import com.example.demo.Model.User;
import com.example.demo.Service.KhachHangService;
import com.example.demo.Service.QuanLyService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AccountController {

	@Autowired
	private UserService userService;
	
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
