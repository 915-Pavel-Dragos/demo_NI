package GameStore.GameStore.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import GameStore.GameStore.project.model.Game;

@DataJpaTest
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;  

    private static final Date published_date = new Date(System.currentTimeMillis()); 

    @Test
    @Transactional
    @Rollback
    public void testSavedGame() {
        Game testGame = new Game(
            "test", 
            published_date, 
            10, 
            10, 
            null);

        Game savedGame = gameRepository.save(testGame);

        assertNotNull(savedGame);

        assertNotNull(savedGame.getId());

        assertEquals("test", savedGame.getName());

        assertEquals(10, savedGame.getCopiesSold());

        assertEquals(10, savedGame.getAchivements());

        assertEquals(null, savedGame.getUser());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindGameById() {
        Game testGame1 = new Game(
            "test1", 
            published_date, 
            10, 
            10, 
            null);
        
        Game testGame2 = new Game(
            "test2", 
            published_date, 
            20, 
            20, 
            null);

        Game savedGame1 = gameRepository.save(testGame1);
        Game savedGame2 = gameRepository.save(testGame2);

        assertNotNull(savedGame1);
        assertNotNull(savedGame2);

        assertNotNull(gameRepository.findById(1L));

        assertNotNull(gameRepository.findById(2L));
    }
}