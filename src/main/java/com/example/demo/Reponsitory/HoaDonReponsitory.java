package com.example.demo.Reponsitory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.HoaDon;
import com.example.demo.Model.ThongKe;

public interface HoaDonReponsitory extends JpaRepository<HoaDon, Long>{

	List<HoaDon> findByNgayThanhToanAfterAndNgayThanhToanBefore(Date ngayBatDau, Date ngayKetThuc);

}
