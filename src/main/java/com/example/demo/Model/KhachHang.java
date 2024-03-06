package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Data
@PrimaryKeyJoinColumn(name = "idUser")
@Table(name = "khachhang")
public class KhachHang extends User{
}
