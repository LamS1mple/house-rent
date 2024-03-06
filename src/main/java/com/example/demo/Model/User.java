package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@Column	
	private String ten;
	
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
