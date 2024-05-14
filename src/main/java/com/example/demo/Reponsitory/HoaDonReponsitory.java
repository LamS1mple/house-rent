package com.example.demo.Reponsitory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.HoaDon;
import com.example.demo.Model.ThongKe;

public interface HoaDonReponsitory extends JpaRepository<HoaDon, Long> {
	@Query(value = "SELECT distinct hd.* FROM chitietdichvu ctdv right join hoadon hd on hd.id = ctdv.hoa_don_id where date_format(hd.ngay_len_hoa_don, \"%m\") = ?1 and date_format(hd.ngay_len_hoa_don, \"%Y\") = ?2\r\n"
			+ "order by hd.ngay_len_hoa_don;", nativeQuery = true)
	List<HoaDon> getMonth(int month, int year);

	@Query(value = "SELECT distinct hd.* FROM chitietdichvu ctdv right join hoadon hd on hd.id = ctdv.hoa_don_id where date_format(hd.ngay_len_hoa_don, \"%m\") >= ?1\r\n"
			+ "				and date_format(hd.ngay_len_hoa_don, \"%m\") <= ?2 and date_format(hd.ngay_len_hoa_don, \"%Y\") = ?3\r\n"
			+ "				order by hd.ngay_len_hoa_don", nativeQuery = true)
	List<HoaDon> getQuarter(int thangBatDau, int thangKetThuc, int nam);

	@Query(value = "select test.thoigian, (test.tongtien + test.don_gia_phong) tongTien from \r\n"
			+ "	(SELECT date_format(hd.ngay_len_hoa_don,\"%m-%Y\") thoigian, sum(if(ctdvCu.dich_vu_moi_id is not null , ctdvMoi.so_luong - ctdvCu.so_luong , ctdvCu.so_luong) * dv.don_gia) tongtien, phong.don_gia_phong\r\n"
			+ "	FROM chitietdichvu ctdvCu, chitietdichvu ctdvMoi, hoadon hd , dichvu dv, phongdat, phong\r\n"
			+ "	where hd.id = ctdvCu.hoa_don_id and ctdvCu.dich_vu_moi_id = ctdvMoi.id and hd.ngay_len_hoa_don is not null\r\n"
			+ "	and phongdat.id = hd.phong_dat_id and phongdat.phong_id = phong.id\r\n"
			+ "	and dv.id = ctdvCu.dich_vu_id\r\n" + "	group by thoigian, phong.don_gia_phong) test\r\n"
			+ "    order by thoigian;", nativeQuery = true)
	List<ThongKe> getMonthOfYear();

}
