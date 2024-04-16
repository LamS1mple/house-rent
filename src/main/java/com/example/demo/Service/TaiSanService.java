package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.Phong;
import com.example.demo.Model.TaiSan;
import com.example.demo.Reponsitory.TaiSanReponsitory;
import com.example.demo.data.request.ChiTietTaiSanRequest;

@Service
public class TaiSanService {
	
	@Autowired
	private TaiSanReponsitory taiSanReponsitory;
	
	public  ResponseEntity< List<TaiSan> > getAllTaiSan() {
		List<TaiSan> danhSachTaiSan = taiSanReponsitory.findAll();
		return new ResponseEntity<List<TaiSan>>(danhSachTaiSan, HttpStatus.ACCEPTED);
		
	}

	

}
