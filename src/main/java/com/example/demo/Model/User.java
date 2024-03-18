package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@Column	
	private String ten;
	
	@Column(unique = true)
	private String taiKhoan;
	
	@Column
	private String matKhau;
	
	@Column
	private String soDienThoai;
	
	@Column
	private String email;
	
	@Column
	private int vaiTro;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] photo;

	
	
	
	
}
