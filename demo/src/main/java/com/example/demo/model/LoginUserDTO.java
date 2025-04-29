package com.example.demo.model;

public class LoginUserDTO {
    private String email;
    private String password;

    // Getters
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    // Setters 
    public void setEmail(String new_email) { this.email = new_email; }
    public void setPassword(String new_password) { this.password = new_password; }
}