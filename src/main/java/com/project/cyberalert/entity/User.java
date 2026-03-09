package com.project.cyberalert.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(unique = true)
private String username;

@Column(unique = true)
private String email;

private String password;

private String role;

private String country;

private String city;

private Double latitude;

private Double longitude;

@Column(name="alert_enabled")
private Boolean alertEnabled = true;

private Boolean enabled = true;

@Column(name="created_at")
private Timestamp createdAt;

public User(){}

public Long getId(){ return id; }

public void setId(Long id){ this.id=id; }

public String getUsername(){ return username; }

public void setUsername(String username){ this.username=username; }

public String getEmail(){ return email; }

public void setEmail(String email){ this.email=email; }

public String getPassword(){ return password; }

public void setPassword(String password){ this.password=password; }

public String getRole(){ return role; }

public void setRole(String role){ this.role=role; }

public String getCountry(){ return country; }

public void setCountry(String country){ this.country=country; }

public String getCity(){ return city; }

public void setCity(String city){ this.city=city; }

public Double getLatitude(){ return latitude; }

public void setLatitude(Double latitude){ this.latitude=latitude; }

public Double getLongitude(){ return longitude; }

public void setLongitude(Double longitude){ this.longitude=longitude; }

public Boolean getAlertEnabled(){ return alertEnabled; }

public void setAlertEnabled(Boolean alertEnabled){ this.alertEnabled=alertEnabled; }

public Boolean getEnabled(){ return enabled; }

public void setEnabled(Boolean enabled){ this.enabled=enabled; }

public Timestamp getCreatedAt(){ return createdAt; }

public void setCreatedAt(Timestamp createdAt){ this.createdAt=createdAt; }

}