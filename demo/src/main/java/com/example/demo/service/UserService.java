package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.Game;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<Game> allGames(Integer id) {
        List<Game> games = new ArrayList<>();

        User current_user = userRepository.findById(id).orElse(null);

        games = current_user.getGames();

        return games;
    }
 }