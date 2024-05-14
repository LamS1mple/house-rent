package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChiTietDichVu;
import com.example.demo.Model.HoaDon;
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
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ThongKe> getThongKe(DateRequest deRequest) {
		List<ThongKe> listThongKes = new ArrayList<>();
		System.out.println(deRequest);
		if (deRequest.isMonth()) { // month
			
			listThongKes = jdbcTemplate.query("select date_format(ngay_thanh_toan, \"%m\") thoigian, sum(if (tongTien is null, don_gia_phong, don_gia_phong + tongTien)) as tongTien from (\r\n"
					+ "select hoadon.id, sum( if(ctdvC.dich_vu_moi_id is null , ctdvC.so_luong * dichvu.don_gia, (ctdvM.so_luong - ctdvC.so_luong)*dichvu.don_gia ) ) as tongTien\r\n"
					+ "  from hoadon, chitietdichvu ctdvC , chitietdichvu ctdvM, dichvu \r\n"
					+ "where dichvu.id = ctdvC.dich_vu_id and ctdvC.hoa_don_id = hoadon.id  and ctdvM.dich_vu_id = dichvu.id\r\n"
					+ "and (ctdvC.dich_vu_moi_id = ctdvM.id or ctdvC.dich_vu_moi_id is null) and ctdvC.hoa_don_id is not null\r\n"
					+ "\r\n"
					+ "group by hoadon.id \r\n"
					+ ") as dv right join (select hoadon.id, hoadon.ngay_thanh_toan , phong.don_gia_phong from hoadon, phongdat, phong \r\n"
					+ "where phong.id = phongdat.phong_id and hoadon.phong_dat_id = phongdat.id) as p\r\n"
					+ "on p.id = dv.id\r\n"
					+ "where date_format(ngay_thanh_toan, \"%Y\") = " + deRequest.getNam() 
					+ " group by thoigian\r\n"
					+ "order by thoigian\r\n"
					, new BeanPropertyRowMapper<>(ThongKe.class));

		} else { // Quarter
			listThongKes = jdbcTemplate.query("select quarter(ngay_thanh_toan) thoigian, sum(if (tongTien is null, don_gia_phong, don_gia_phong + tongTien)) as tongTien from (\r\n"
					+ "select hoadon.id, sum( if(ctdvC.dich_vu_moi_id is null , ctdvC.so_luong * dichvu.don_gia, (ctdvM.so_luong - ctdvC.so_luong)*dichvu.don_gia ) ) as tongTien\r\n"
					+ "  from hoadon, chitietdichvu ctdvC , chitietdichvu ctdvM, dichvu \r\n"
					+ "where dichvu.id = ctdvC.dich_vu_id and ctdvC.hoa_don_id = hoadon.id  and ctdvM.dich_vu_id = dichvu.id\r\n"
					+ "and (ctdvC.dich_vu_moi_id = ctdvM.id or ctdvC.dich_vu_moi_id is null) and ctdvC.hoa_don_id is not null\r\n"
					+ "\r\n"
					+ "group by hoadon.id \r\n"
					+ ") as dv right join (select hoadon.id, hoadon.ngay_thanh_toan , phong.don_gia_phong from hoadon, phongdat, phong \r\n"
					+ "where phong.id = phongdat.phong_id and hoadon.phong_dat_id = phongdat.id) as p\r\n"
					+ "on p.id = dv.id\r\n"
					+ "where date_format(ngay_thanh_toan, \"%Y\") = " + deRequest.getNam() 
					+ " group by thoigian\r\n"
					+ "order by thoigian\r\n"
					, new BeanPropertyRowMapper<>(ThongKe.class));
			
		}

		return listThongKes;
	}

	public long tongTien(List<HoaDon> list) {
		long tongTienThongKe = 0;
		for (HoaDon i : list) {
			tongTienThongKe += i.getPhongDat().getPhong().getDonGiaPhong();
			for (ChiTietDichVu j : i.getChiTietDichVuThang()) {
				if (j.getDichVuMoi() != null) {
					tongTienThongKe += (j.getDichVuMoi().getSoLuong() - j.getSoLuong()) * j.getDichVu().getDonGia();
				} else {
					tongTienThongKe += j.getSoLuong() * j.getDichVu().getDonGia();
				}
			}
		}
		return tongTienThongKe;
	}

	public List<ThongKe> getHoaDonOfMonth(DateRequest dateRequest) {
		List<ThongKe> listThongKes = new ArrayList<>();

		if (dateRequest.isMonth()) { // month
			
			List<HoaDon> hoaDons = hoaDonReponsitory.getMonth(dateRequest.getValueMonthQuerter()
					, dateRequest.getNam() );
			listThongKes = thongKeHoaDon(hoaDons);	
		} else { // Quarter
			
		        int thangBatDau = (dateRequest.getValueMonthQuerter() - 1) * 3 + 1 ; 
		        int thangKetThuc = thangBatDau + 2; 

		        List<HoaDon> hoaDons = hoaDonReponsitory.getQuarter(thangBatDau, thangKetThuc, dateRequest.getNam());
				listThongKes = thongKeHoaDon(hoaDons);

		    
		}
		return listThongKes;
	}

	private List<ThongKe> thongKeHoaDon(List<HoaDon> hoaDons) {
		List<ThongKe> listThongKes = new ArrayList<>();
		
		for (HoaDon iDon : hoaDons) {
			ThongKe thongKe = new ThongKe(iDon);
			thongKe.setTongTien(tongTienHoaDon(iDon));
			
			listThongKes.add(thongKe);
		}
		return listThongKes;
	}
	private long tongTienHoaDon(HoaDon hoaDon) {
		long tien = 0;
		tien += hoaDon.getPhongDat().getPhong().getDonGiaPhong();
		for (ChiTietDichVu j : hoaDon.getChiTietDichVuThang()) {
			if (j.getDichVuMoi() != null) {
				tien += (j.getDichVuMoi().getSoLuong() - j.getSoLuong()) * j.getDichVu().getDonGia();
			} else {
				tien += j.getSoLuong() * j.getDichVu().getDonGia();
			}
		}
		
		return tien;
	}
}
