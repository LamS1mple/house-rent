package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "dichvu")
@NoArgsConstructor
@AllArgsConstructor
public class DichVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String tenDichVu;
	
	@Column
	private long donGia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
	private List<ChiTietDichVu> danhSachDichVu;
}
