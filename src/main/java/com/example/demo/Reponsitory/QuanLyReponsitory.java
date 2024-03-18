package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.KhachHang;
import com.example.demo.Model.QuanLy;

@Repository
public interface QuanLyReponsitory extends JpaRepository<QuanLy, Long>{
	QuanLy findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);
}
