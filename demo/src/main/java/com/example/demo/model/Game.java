package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Game{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
    private String name;
    private Date date_published;
    private int copies_sold;
    private int no_achivements;

    // Getters and Setters 
    public Long GetId() { return Id; }
    public void setId(Long id) { this.Id = id; }
    
    public String GetName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Date GetDatePublished() { return date_published; }
    public void setDatePublished(Date new_date) { this.date_published = new_date; }

    public int GetCopiesSold() { return copies_sold; }
    public void setCopiesSold(int new_copies) { this.copies_sold = new_copies; }

    public int GetAchivements() { return no_achivements; }
    public void setAchivements(int new_acvhivements) { this.no_achivements = new_acvhivements; }
    
}