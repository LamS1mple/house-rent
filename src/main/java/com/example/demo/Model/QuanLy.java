package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@PrimaryKeyJoinColumn(name = "idQuanLy")
@Table(name = "quanly")
public class QuanLy extends User{

	

}
