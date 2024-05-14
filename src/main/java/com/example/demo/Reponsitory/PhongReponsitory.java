package com.example.demo.Reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Phong;


@Repository
public interface PhongReponsitory extends JpaRepository<Phong, Long>{

	@Query(value = "select * from phong where phong.id not in (select distinct phongdat.phong_id from hop_dong , landat, phongdat\r\n"
			+ "where landat.id = hop_dong.lan_dat_id and phongdat.lan_dat_id = landat.id \r\n"
			+ "and ((ngay_bat_dau between ?1 and  ?2) \r\n"
			+ "or (ngay_het_han  between ?1 and  ?2)));", nativeQuery = true)
	public List<Phong> findPhongTrong(Date ngayBatDau, Date ngayKetThuc);
	
	
}
