package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@PrimaryKeyJoinColumn(name = "idQuanLy")
@Table(name = "quanly")
public class QuanLy extends User{

}
