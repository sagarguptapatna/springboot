package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.execption.ResourceNotFoundExeption;
import com.example.demo.repo.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundExeption("User With ","Email "+username,0));
		
		return user;
	}

}
