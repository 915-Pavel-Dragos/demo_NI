package GameStore.GameStore.project.service;

import java.util.List;
import java.util.Optional;

import GameStore.GameStore.project.model.GameDTO;

public interface GameService{
    List<GameDTO> getAllGames();
    Optional<GameDTO> getGameById(Long Id);
    GameDTO saveGame(GameDTO gameDTO);
    GameDTO updaGame(Long Id, GameDTO gameDTO);
    void deleteGame(Long Id);
}
