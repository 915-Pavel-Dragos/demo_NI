package GameStore.GameStore.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import GameStore.GameStore.project.model.GameDTO;
import GameStore.GameStore.project.model.User;
import GameStore.GameStore.project.service.GameService;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        GameDTO newGameDTO = new GameDTO(
            gameDTO.name(),
            gameDTO.date_published(), 
            gameDTO.copies_sold(), 
            gameDTO.no_achivements(), 
            currentUser);

        return gameService.saveGame(newGameDTO);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long Id, @RequestBody GameDTO gameDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        GameDTO newGameDTO = new GameDTO(
            gameDTO.name(),
            gameDTO.date_published(), 
            gameDTO.copies_sold(), 
            gameDTO.no_achivements(), 
            currentUser);

        try{
            GameDTO updatedGame = gameService.updaGame(Id, newGameDTO);
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