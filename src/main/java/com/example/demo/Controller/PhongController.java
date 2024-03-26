package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Phong;
import com.example.demo.Service.PhongService;

@RestController
public class PhongController {

	@Autowired
	private PhongService phongService;
	
	@GetMapping("/phong/list-phong")
	public List<Phong> getAllPhong(){
		return phongService.getAllPhong();
	}
	
	@GetMapping("/phong/{id}")
	public Phong getPhongById(@PathVariable(name = "id") int idPhong) {
		return phongService.getPhongById(idPhong);
	}
}
