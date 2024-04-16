package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.HopDong;
import com.example.demo.Model.KhachHang;
import com.example.demo.Model.LanDat;
import com.example.demo.Model.PhongDat;
import com.example.demo.Model.QuanLy;
import com.example.demo.Service.KhachHangService;
import com.example.demo.Service.QuanLyService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
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
	
	@PostMapping("/login-khach-hang")
	public KhachHang loginAcount(@RequestBody KhachHang khachHang
			) {
		KhachHang checkKhachHang = khachHangService.checkAcount(khachHang);
		if (checkKhachHang == null) {
			return null;
		}
	
		

		return checkKhachHang;
	}
	
	
	
	
	
}
