package GameStore.GameStore.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserTest {

    @Autowired
    private TestEntityManager entityManager;

    private User user_entity_test;

    Date createdAt = new Date(System.currentTimeMillis());
    Date updatedAt = new Date(System.currentTimeMillis());

    List<Game> games = new ArrayList<Game>();

    @BeforeEach
    public void setUp() {
        user_entity_test = new User(
            "admin", 
            "admin@adm.com", 
            "admin", 
            createdAt, 
            updatedAt, 
            games);
    }

    @Test
    public void userFullNameTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.getFullName(), "admin");
    }

    @Test
    public void userEmailTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.getEmail(), "admin@adm.com");
    }

    @Test
    public void userPasswordTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.getPassword(), "admin");
    }

    @Test
    public void userCreatedAtTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.getCreatedAt(), createdAt);
    }

    @Test
    public void userUpdatedAtTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.getUpdatedAt(), updatedAt);
    }

    @Test
    public void userToStringTest() {
        User savedUser = this.entityManager.persist(user_entity_test);
        assertEquals(savedUser.toString(), "User: id - " + savedUser.getId() + 
                                            ", fullName: " + savedUser.getFullName() + 
                                            ", email: " + savedUser.getEmail());
    }
}