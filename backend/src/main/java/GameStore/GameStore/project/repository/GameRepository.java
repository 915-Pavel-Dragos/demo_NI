package GameStore.GameStore.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GameStore.GameStore.project.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}