package com.example.demo.model;

import java.sql.Date;

public record GameDTO(Long Id, String name, Date date_published, int copies_sold, int no_achivements){}