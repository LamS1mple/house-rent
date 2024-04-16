package com.example.demo.Reponsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.Phong;

public interface ChiTietTaiSanReponsitory extends JpaRepository<ChiTietTaiSan, Long>{
	List<ChiTietTaiSan> findByPhong(Phong phong);
}
