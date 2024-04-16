package com.example.demo.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.Phong;
import com.example.demo.Model.TaiSan;
import com.example.demo.Reponsitory.ChiTietTaiSanReponsitory;
import com.example.demo.data.request.ChiTietTaiSanRequest;

@Service
public class ChiTietTaiSanService {

	@Autowired
	private ChiTietTaiSanReponsitory chiTietTaiSanReponsitory;
	
	public ResponseEntity<Map<String, String>> deleteTaiSanCuaPhong(long id){
		
		chiTietTaiSanReponsitory.deleteById(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "thanhcong"); 
		return new ResponseEntity< Map<String,String> >(map, HttpStatus.ACCEPTED);
		
	}

	public ResponseEntity<ChiTietTaiSan> saveTaiSanPhong(ChiTietTaiSanRequest chiTietTaiSanRequest) {
		
		ChiTietTaiSan chiTietTaiSan = ChiTietTaiSan.builder()
				.soLuong(chiTietTaiSanRequest.getSoLuong())
				.moTa(chiTietTaiSanRequest.getMoTa())
				.phong(Phong.builder().id(chiTietTaiSanRequest.getPhongId()).build() )
				.taiSan( TaiSan.builder().id(chiTietTaiSanRequest.getTaiSanId()).build() )
				.build();
		if ( chiTietTaiSanRequest.getId()!= 0) {
			chiTietTaiSan.setId(chiTietTaiSanRequest.getId());
		}
		chiTietTaiSan = chiTietTaiSanReponsitory.save(chiTietTaiSan);
		return new ResponseEntity<ChiTietTaiSan>(chiTietTaiSan , HttpStatus.ACCEPTED);
	}
}
