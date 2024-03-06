package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "chitettaisan")

public class ChiTietTaiSan {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int soLuong;
	
	@ManyToOne
	@JoinColumn(name = "taiSan_id")
	private TaiSan taiSan;
	
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
}
