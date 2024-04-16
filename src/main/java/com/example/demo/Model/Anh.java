package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Anh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	
	@Column
	private String anh;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "phong_id")
	private Phong phong;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "TaiSan_id")
	private TaiSan taiSan;
	
}
