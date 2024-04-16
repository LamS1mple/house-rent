package com.example.demo.Model;

import java.sql.Date;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "hoadon")
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	protected long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	protected Date ngayThanhToan;
	
	@Column
	@Temporal(TemporalType.DATE)
	protected Date ngayLenHoaDon;
	
	@ManyToOne
	@JoinColumn(name = "phong_dat_id")
	protected PhongDat phongDat;
	

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	
	

	
	
	
}
