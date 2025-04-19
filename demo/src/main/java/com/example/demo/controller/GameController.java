package com.example.demo.controller;

import com.example.demo.model.GameDTO;
import com.example.demo.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController{
    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping 
    public List<GameDTO> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long Id){
        Optional<GameDTO> game = gameService.getGameById(Id);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO gameDTO){
        return gameService.saveGame(gameDTO);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long Id, @RequestBody GameDTO gameDTO){
        try{
            GameDTO updatedGame = gameService.updaGame(Id, gameDTO);
            return ResponseEntity.ok(updatedGame);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long Id){
        gameService.deleteGame(Id);
        return ResponseEntity.noContent().build();
    }
}