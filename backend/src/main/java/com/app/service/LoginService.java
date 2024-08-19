package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DonerDto;
import com.app.dto.NgoDto;
import com.app.entity.DonerEntity;
import com.app.entity.NgoEntity;
import com.app.repositories.DonerRepository;
import com.app.repositories.NgoRepository;

@Service
@Transactional
public class LoginService {
	
	@Autowired 
	public DonerRepository donerRepository;
	
	@Autowired 
	public NgoRepository ngoRepository;
	
	@Autowired 
	public ModelMapper modelMapper;
	
	public LoginService(DonerRepository donerRepository,NgoRepository ngoRepository)
	{
		super ();
		this.donerRepository = donerRepository;
		this.ngoRepository = ngoRepository;
	}
	
	public DonerDto DonerLogin(String email,String password)
	{
		DonerEntity donerEntity = donerRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new RuntimeException("Wrong email or password"));
		return modelMapper.map(donerEntity,DonerDto.class);
	}
	public NgoDto NgoLogin(String email,String password) {
		NgoEntity ngoEntity = ngoRepository.findByEmailAndPassword(email,password).orElseThrow(()-> new RuntimeException ("Wrong email or password for Ngo"));
		return modelMapper.map(ngoEntity,NgoDto.class);
	}
	
}
