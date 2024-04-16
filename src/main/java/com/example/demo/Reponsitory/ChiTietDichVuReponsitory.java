package com.example.demo.Reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ChiTietDichVu;
import com.example.demo.Model.PhongDat;

public interface ChiTietDichVuReponsitory extends JpaRepository<ChiTietDichVu, Long>{

	List<ChiTietDichVu> findByPhongDatAndNgayKetThucEquals(PhongDat phongDat, Date ngayLenHoaDon);

}
