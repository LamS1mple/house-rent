package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.TaiSan;
import com.example.demo.Service.ChiTietTaiSanService;
import com.example.demo.Service.TaiSanService;
import com.example.demo.data.request.ChiTietTaiSanRequest;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(value = "*")
public class TaiSanController {

	@Autowired
	private ChiTietTaiSanService chiTietTaiSanService;
	
	
	@Autowired
	private TaiSanService taiSanService;
	@GetMapping("/chi-tiet-tai-san/{id}")
	public ResponseEntity<Map<String, String>> deleteTaiSan (@PathVariable("id") int id){
		
		return chiTietTaiSanService.deleteTaiSanCuaPhong(id);
		
	}
	
	@GetMapping("/tai-san/get-all-tai-san")
	public ResponseEntity<List<TaiSan>> getAllTaiSan(){
		return taiSanService.getAllTaiSan();
		
	}
	
	@PostMapping( value = "/tai-san/save-tai-san-phong")
	public ResponseEntity<ChiTietTaiSan> saveTaiSanPhong(@RequestBody ChiTietTaiSanRequest chiTietTaiSan){
		System.out.println(chiTietTaiSan.toString());
		return chiTietTaiSanService.saveTaiSanPhong(chiTietTaiSan);
	}
}
