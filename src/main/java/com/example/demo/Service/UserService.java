package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.KhachHang;
import com.example.demo.Model.Phong;
import com.example.demo.Model.PhongDat;
import com.example.demo.Model.QuanLy;
import com.example.demo.Model.User;
import com.example.demo.Reponsitory.UserReponsitory;

@Service
public class UserService{

	private UserReponsitory userReponsitory;
	
	@Autowired
	public UserService(UserReponsitory userReponsitory) {
		this.userReponsitory = userReponsitory;
	}
	
	public String createUser(User user) {
		
		userReponsitory.save(user);
		return "thanh cong";
	}

}
