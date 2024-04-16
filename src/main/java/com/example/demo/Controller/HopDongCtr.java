package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.HopDong;
import com.example.demo.Service.HopDongService;

@RestController
@CrossOrigin(value = "*")
public class HopDongCtr {
	
	@Autowired
	private HopDongService hopDongService;
	
	@PostMapping("/hop-dong/save-hop-dong")
	public Map<String, Boolean> saveHopDong(@RequestBody HopDong hopDong){
		hopDongService.saveHopDong(hopDong);
		return null;
	}

}
