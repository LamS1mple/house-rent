package com.example.demo.Controller;

import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.Model.LanDat;
import com.example.demo.Model.Phong;
import com.example.demo.Model.PhongDat;
import com.example.demo.Service.PhongService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value = "*")
public class LanDatController {
	
	
	@Autowired
	private PhongService phongService;

	@PostMapping("/lan-dat/them-lan-dat")
	public Map<String, Boolean> addPhongDat(@RequestBody PhongDat phongDat, HttpServletRequest request){
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		
		   
		try {
			LanDat lanDat = (LanDat) request.getSession().getAttribute("landat");
			lanDat.getDanhSachPhongDat().add(phongDat);
			request.getSession().setAttribute("landat", lanDat);
			map.put("status", true);
			return map;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		map.put("status", false);

		return map;
		
	}
	@PostMapping("/lan-dat/get-lan-dat")
	public List<Phong> getPhongDat(@RequestBody List<Long> idDanhSachPhong){
		
		return phongService.getPhongChon(idDanhSachPhong);
	}
	
}
