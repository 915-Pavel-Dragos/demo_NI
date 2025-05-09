package GameStore.GameStore.project.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date_published;

    @Column(nullable = false)
    private int copies_sold;

    @Column(nullable = false)
    private int no_achivements;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Game(
        Long id,
        String name,
        Date date_published,
        int copies_sold,
        int no_achivements,
        User user
    ) {
        this.Id = id;
        this.name = name;
        this.date_published = date_published;
        this.copies_sold = copies_sold;
        this.no_achivements = no_achivements;
        this.user = user;
    }

    public Game(
        String name,
        Date date_published,
        int copies_sold,
        int no_achivements,
        User user
    ) {
        this.name = name;
        this.date_published = date_published;
        this.copies_sold = copies_sold;
        this.no_achivements = no_achivements;
        this.user = user;
    }

    public Game() {
        this.Id = null;
        this.name = null;
        this.date_published = null;
        this.copies_sold = 0;
        this.no_achivements = 0;
        this.user = new User();
    }

    // Getters and Setters 
    public Long getId() { return Id; }
    public Game setId(Long id) { this.Id = id; return this; }
    
    public String getName() { return name; }
    public Game setName(String name) { this.name = name; return this; }
    
    public Date getDatePublished() { return date_published; }
    public Game setDatePublished(Date new_date) { this.date_published = new_date; return this; }

    public int getCopiesSold() { return copies_sold; }
    public Game setCopiesSold(int new_copies) { this.copies_sold = new_copies; return this; }

    public int getAchivements() { return no_achivements; }
    public Game setAchivements(int new_acvhivements) { this.no_achivements = new_acvhivements; return this; }

    public User getUser() { return this.user; }
    public Game setUser(User new_user) { this.user = new_user; return this; }

    @Override
    public String toString() {
        return "Game: name " + this.name + ", id: " + this.Id + 
                ", date_published: " + this.date_published + 
                ", copies_sold: " + this.copies_sold + 
                ", achivements: " + this.no_achivements;
    }
    
}