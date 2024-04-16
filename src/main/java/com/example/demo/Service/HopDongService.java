package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.HopDong;
import com.example.demo.Model.LanDat;
import com.example.demo.Model.Phong;
import com.example.demo.Model.PhongDat;
import com.example.demo.Reponsitory.HopDongReponsitory;
import com.example.demo.Reponsitory.LanDatReponsitory;
import com.example.demo.Reponsitory.PhongDatReponsitory;
import com.example.demo.Reponsitory.PhongReponsitory;

import jakarta.transaction.Transactional;

@Service
public class HopDongService {

	
	@Autowired
	private HopDongReponsitory hopDongReponsitory;
	
	@Autowired 
	private LanDatReponsitory lanDatReponsitory;
	
	@Autowired
	private PhongDatReponsitory phongDatReponsitory;
	
	@Autowired
	private PhongReponsitory phongReponsitory;
	
	@Transactional
	public void saveHopDong(HopDong hopDong) {
		LanDat hDong = lanDatReponsitory.save(hopDong.getLanDat());
		hopDong.setLanDat(hDong);
		hopDongReponsitory.save(hopDong);
		List<PhongDat> list = new ArrayList<PhongDat>();
		for (PhongDat i : hDong.getDanhSachPhongDat()) {
			System.out.println(i.toString());
			Phong updatePhong =  phongReponsitory.findById(i.getPhong().getId()).get();
			updatePhong.setTrangThai(true);
			phongReponsitory.save(updatePhong);
			i.setLanDat(hDong);
			list.add(i);
			
		}
		phongDatReponsitory.saveAll(list);
		
	}
}
