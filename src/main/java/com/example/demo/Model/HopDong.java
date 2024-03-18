package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder

public class HopDong {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(
			name = "lanDat_id"
			)
	private LanDat lanDat;
}
