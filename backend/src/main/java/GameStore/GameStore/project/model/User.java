package GameStore.GameStore.project.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

    public User(
        Integer id,
        String fullName,
        String email,
        String password,
        Date createdAt,
        Date updatedAt,
        List<Game> games
    ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.games = games;
    }

    public User(
        String fullName,
        String email,
        String password,
        Date createdAt,
        Date updatedAt,
        List<Game> games
    ) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.games = games;
    }

    public User() {
        this.id = null;
        this.fullName = null;
        this.email = null;
        this.password = null;
        this.createdAt = null;
        this.updatedAt = null;
        this.games = null;
    }

    // Getters 

    public Integer getId() { return this.id; }
    public String getFullName() { return this.fullName; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }
    public List<Game> getGames() { return this.games; }

    // Setters
    public User setId(Integer new_id) { this.id = new_id; return this; }
    public User setFullName(String new_fullName) { this.fullName = new_fullName; return this; }
    public User setEmail(String new_email) { this.email = new_email; return this; }
    public User setPassword(String new_pass) { this.password = new_pass; return this; }
    public User setCreatedAt(Date new_createdAt) { this.createdAt = new_createdAt; return this; }
    public User setUpdatedAt(Date new_updatedAt) { this.updatedAt = new_updatedAt; return this; }
    public User setGames(List<Game> new_games) { this.games = new_games; return this; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired(){ return true; } 

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Override
    public String toString() {
        return "User: id - " + this.id + 
                ", fullName: " + this.fullName + 
                ", email: " + this.email;
    }
}