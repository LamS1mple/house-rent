package com.example.demo.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Phong;

public interface PhongReponsitory extends JpaRepository<Phong, Long>{

	public List<Phong> findByTrangThai(boolean checkEmpty);
}
