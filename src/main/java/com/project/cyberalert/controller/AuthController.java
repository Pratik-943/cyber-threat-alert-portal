package com.project.cyberalert.controller;

import com.project.cyberalert.entity.User;
import com.project.cyberalert.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;


// LOGIN
@PostMapping("/login")
public Map<String,Object> login(@RequestBody LoginRequest request){

Map<String,Object> response=new HashMap<>();

User user=userRepository.findByUsername(request.getUsername())
.orElse(null);

if(user==null){
response.put("status","USER_NOT_FOUND");
return response;
}

if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
response.put("status","INVALID_PASSWORD");
return response;
}

response.put("status","SUCCESS");
response.put("username",user.getUsername());
response.put("role",user.getRole());

return response;

}


// REGISTER
@PostMapping("/register")
public Map<String,String> register(@RequestBody RegisterRequest request){

Map<String,String> response=new HashMap<>();

if(userRepository.findByUsername(request.getUsername()).isPresent()){
response.put("status","USERNAME_EXISTS");
return response;
}

if(userRepository.findByEmail(request.getEmail()).isPresent()){
response.put("status","EMAIL_EXISTS");
return response;
}

User user=new User();

user.setUsername(request.getUsername());
user.setEmail(request.getEmail());
user.setPassword(passwordEncoder.encode(request.getPassword()));

user.setRole("ROLE_USER");
user.setEnabled(true);
user.setAlertEnabled(true);

user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

userRepository.save(user);

response.put("status","SUCCESS");

return response;

}

}