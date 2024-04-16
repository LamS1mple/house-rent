package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChiTietDichVu;
import com.example.demo.Model.PhongDat;
import com.example.demo.Model.ThongKe;
import com.example.demo.Reponsitory.ChiTietDichVuReponsitory;
import com.example.demo.Reponsitory.HoaDonReponsitory;
import com.example.demo.data.request.DateRequest;

@Service
public class ThongKeService {

	@Autowired
	private HoaDonReponsitory hoaDonReponsitory;
	
	@Autowired
	private ChiTietDichVuReponsitory chiTietDichVuReponsitory;
	
	public List<ThongKe> getThongKe(DateRequest deRequest) {
		List<ThongKe> list = new ArrayList<ThongKe>();
		hoaDonReponsitory.findByNgayThanhToanAfterAndNgayThanhToanBefore(
				deRequest.getNgayBatDau(), deRequest.getNgayKetThuc()
				).stream().forEach(Item ->{
					PhongDat phongDat =  Item.getPhongDat();
					List<ChiTietDichVu> listChiTietDichVus = chiTietDichVuReponsitory.findByPhongDatAndNgayKetThucEquals(phongDat, Item.getNgayLenHoaDon());
					phongDat.setDanhSachChiTietDichVu(listChiTietDichVus);
			ThongKe thongKe = new ThongKe(Item.getId(),Item.getNgayThanhToan(), Item.getNgayLenHoaDon(),phongDat);
			
			list.add(thongKe);
		});;
		return list;
	}
	
}
