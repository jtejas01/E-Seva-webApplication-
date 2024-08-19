package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DonerDto;
import com.app.dto.LoginRequest;
import com.app.dto.NgoDto;
import com.app.service.LoginService;
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping("/Doner")
	@CrossOrigin(origins = "http://localhost:5173")
	public DonerDto loginDoner(@RequestBody LoginRequest donerLoginRequest)
	{
		return loginService.DonerLogin(donerLoginRequest.getEmail(),donerLoginRequest.getPassword());
	}
	@PostMapping("/Ngo")
	@CrossOrigin(origins = "http://localhost:5173")
	public NgoDto loginNgo(@RequestBody LoginRequest ngoLoginRequest)
	{
		return loginService.NgoLogin(ngoLoginRequest.getEmail(),ngoLoginRequest.getPassword());
	}
	
}
