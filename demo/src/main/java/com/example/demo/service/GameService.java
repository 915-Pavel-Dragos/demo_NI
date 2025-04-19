package com.example.demo.service;

import com.example.demo.model.GameDTO;

import java.util.List;
import java.util.Optional;

public interface GameService{
    List<GameDTO> getAllGames();
    Optional<GameDTO> getGameById(Long Id);
    GameDTO saveGame(GameDTO gameDTO);
    GameDTO updaGame(Long Id, GameDTO gameDTO);
    void deleteGame(Long Id);
}
