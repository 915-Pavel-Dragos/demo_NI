package GameStore.GameStore.project.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

@DataJpaTest
public class GameTest {

    @Autowired
    private TestEntityManager entityManager;

    private Game game_entity_to_test;

    private User user_entity;

    Date currentDate = new Date(System.currentTimeMillis());

    @BeforeEach
    public void setUp() {
        user_entity = new User(
            "admin",
            "admin@admin.com", 
            "test", 
            currentDate,
            currentDate,
             null);

        this.entityManager.persist(user_entity);

        game_entity_to_test = new Game(
            "test", 
            currentDate, 
            10,
            10, 
            user_entity);
    }

    @Test
    public void gameNameTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.getName(), "test");
    }

    @Test
    public void gameDateTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.getDatePublished(), currentDate);
    }

    @Test
    public void gameCopiesSoldTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.getCopiesSold(), 10);
    }

    @Test
    public void gameAchivementsTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.getAchivements(), 10);
    }

    @Test
    public void gameUserTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.getUser(), user_entity);
    }

    @Test
    public void gameToStringTest() {
        Game savedGame = this.entityManager.persist(game_entity_to_test);
        assertEquals(savedGame.toString(), "Game: name " + savedGame.getName() + 
                                            ", id: " + savedGame.getId() + 
                                            ", date_published: " + savedGame.getDatePublished() + 
                                            ", copies_sold: " + savedGame.getCopiesSold() + 
                                            ", achivements: " + savedGame.getAchivements());
    }
}