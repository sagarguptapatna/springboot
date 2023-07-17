package com.example.demo.restcont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwt.JwtUtill;
import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponse;
import com.example.demo.security.CustomUserDetailsService;

@RestController
public class TestRestCont {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtUtill jwtUtill;
	@Autowired
	private AuthenticationManager authenticationManager;

@PostMapping("/generateTocken")
public ResponseEntity<?> generateTocken(@RequestBody JWTRequest jwtRequest) throws Exception {
	
	try {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		
	}
	catch (UsernameNotFoundException e) {
		e.printStackTrace();
		throw new Exception("Bad Credential");
	}
	catch (BadCredentialsException e) {
		e.printStackTrace();
		throw new Exception("Bad Credential"); 
	}
	
	UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
	String tocken=this.jwtUtill.generateToken(userDetails);
	System.out.println("JWT Tocken "+tocken);
	return ResponseEntity.ok(new JWTResponse(tocken));
}

@GetMapping("/welcome")
public String welcome() {
	
return "Hello";
	
}


}
