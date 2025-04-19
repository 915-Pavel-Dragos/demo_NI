package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.GameDTO;
import com.example.demo.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService{
    
    private final GameRepository gameRepo;

    public GameServiceImpl(GameRepository gameRepo){
        this.gameRepo = gameRepo;
    }

    @Override
    public List<GameDTO> getAllGames(){
        return gameRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<GameDTO> getGameById(Long Id) {
        return gameRepo.findById(Id).map(this::convertToDTO);
    }

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        Game game = convertToEntity(gameDTO);
        Game savedGame = gameRepo.save(game);
        return convertToDTO(savedGame);
    }
    
    @Override
    public GameDTO updaGame(Long Id, GameDTO gameDTO) {
        Game game = gameRepo.findById(Id).orElseThrow();
        game.setName(gameDTO.name());
        game.setDatePublished(gameDTO.date_published());
        game.setCopiesSold(gameDTO.copies_Sold());
        game.setAchivements(gameDTO.no_achivements());
        Game updatedGame = gameRepo.save(game);
        return convertToDTO(updatedGame);
    }
    
    @Override
    public void deleteGame(Long Id) {
        gameRepo.deleteById(Id);
    }

    // Convert GameDTO to Game Entity
    private GameDTO convertToDTO(Game game){
        return new GameDTO(game.GetId(), game.GetName(), game.GetDatePublished(), game.GetCopiesSold(), game.GetAchivements());
    }

    // Convert GameDTO to Game Entity 
    private Game convertToEntity(GameDTO gameDTO){
        Game game = new Game();
        game.setName(gameDTO.name());
        game.setDatePublished(gameDTO.date_published());
        game.setCopiesSold(gameDTO.copies_Sold());
        game.setAchivements(gameDTO.no_achivements());
        return game;
    } 
}