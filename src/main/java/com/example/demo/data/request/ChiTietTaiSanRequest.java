package com.example.demo.data.request;

import com.example.demo.Model.ChiTietDichVu;
import com.example.demo.Model.ChiTietTaiSan;
import com.example.demo.Model.DichVu;
import com.example.demo.Model.Phong;
import com.example.demo.Model.PhongDat;
import com.example.demo.Model.TaiSan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietTaiSanRequest {


	private long id;
	

	private int soLuong;
	
	private String moTa;
	

	private int taiSanId;

	private int phongId;
	
}
