package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.TaiSan;

public interface TaiSanReponsitory extends JpaRepository<TaiSan, Long>{

	@Query( value = "select ts.* from taisan as ts, chitettaisan as ct where ct.id = ?1 and ts.id = ct.tai_san_id",
			nativeQuery = true)
	TaiSan findByDanhSachTaiSan(long id);

}
