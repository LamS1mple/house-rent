package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.HoaDon;
import com.example.demo.Model.ThongKe;
import com.example.demo.Service.ThongKeService;
import com.example.demo.data.request.DateRequest;

@RestController
@CrossOrigin(value = "*")
public class ThongKeController {
	
	@Autowired
	private ThongKeService thongKeService;
	@PostMapping("/thong-ke/thong-ke-doanh-thu")
	public List<ThongKe> getAllHoaDon(@RequestBody DateRequest dateRequest){
		System.out.println(dateRequest.toString());
		return thongKeService.getThongKe(dateRequest);
	}
}
