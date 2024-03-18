package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.KhachHang;


@Repository
public interface KhachHangReponsitory extends JpaRepository<KhachHang, Long> {

	KhachHang findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);

}
