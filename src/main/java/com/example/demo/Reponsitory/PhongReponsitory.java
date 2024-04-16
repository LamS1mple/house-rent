package com.example.demo.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Phong;


@Repository
public interface PhongReponsitory extends JpaRepository<Phong, Long>{

	public List<Phong> findByTrangThai(boolean checkEmpty);
	
	
}
