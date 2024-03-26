package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Exceptions.Exp;
import com.example.demo.Model.Phong;
import com.example.demo.Reponsitory.PhongReponsitory;

public class PhongService {

	@Autowired
	private PhongReponsitory phongReponsitory;
	
	public List<Phong> getAllPhong(){
		List<Phong> listPhong = phongReponsitory.findAll();
		return listPhong;
	}
	
	public List<Phong> getAllPhongEmpty(){
		List<Phong> listPhong = phongReponsitory.findByTrangThai(true);
		return listPhong;
	}

	public Phong getPhongById(long idPhong) {
		Optional<Phong> phong = phongReponsitory.findById(idPhong);
		if (phong.isEmpty()) {
			throw new Exp("Không có phòng với id la"+ idPhong );
		}
		return phong.get();
	}
}
