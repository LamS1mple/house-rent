package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;



@Entity
@PrimaryKeyJoinColumn(name = "idUser")
@Table(name = "khachhang")
public class KhachHang extends User{

	@OneToMany(mappedBy = "khachHang")
	private List<LanDat> lanDat;
}
