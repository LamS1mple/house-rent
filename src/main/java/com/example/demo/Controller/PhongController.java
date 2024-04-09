package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Phong;
import com.example.demo.Service.PhongService;
import com.example.demo.data.response.PhongRe;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin(value = "*")
@RestController
public class PhongController {

	@Autowired
	private PhongService phongService;
	
	@GetMapping("/phong/list-phong")
	public List<PhongRe> getAllPhong(){
		return phongService.getAllPhong();
	}
	
	@GetMapping("/phong/{id}")
	public Phong getPhongById(@PathVariable(name = "id") long idPhong) {
		return phongService.getPhongById(idPhong);
	}
	
	
	@GetMapping("/phong/empty-phong")
	public List<Phong> getPhongEmpty(){
		return phongService.getAllPhongEmpty();
	}
	
	
	
}
