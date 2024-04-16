package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chitettaisan")

public class ChiTietTaiSan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int soLuong;
	
	private String moTa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "taiSan_id")
	private TaiSan taiSan;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "phong_id")
	private Phong phong;
	
	@JsonProperty("taiSan")
	public TaiSan geTaiSan() {
		return taiSan;
	}
	@JsonProperty("taiSan")
	public void setTaiSan(TaiSan taiSan) {
		this.taiSan = taiSan;
	}
	
	
}
