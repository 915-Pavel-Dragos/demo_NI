package GameStore.GameStore.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import GameStore.GameStore.project.model.User;

@DataJpaTest
public class UserRepositoryTest {

    User testUser;

    @Autowired
    private UserRepository userRepository;

    private static final Date createdAt = new Date(System.currentTimeMillis());
    private static final Date updatedAt = new Date(System.currentTimeMillis());

    @BeforeEach
    public void setUp() { 
        testUser = new User(
            "admin", 
            "admin@adm.com", 
            "admin", 
            createdAt, 
            updatedAt,
            null);
    }

    @Test
    @Transactional
    @Rollback
    public void testSavedUser() { 
        User savedUser = userRepository.save(testUser);

        assertNotNull(savedUser);

        assertNotNull(savedUser.getId());

        assertEquals("admin", savedUser.getFullName());

        assertEquals("admin@adm.com", savedUser.getEmail());

        assertEquals(createdAt, savedUser.getCreatedAt());

        assertEquals(updatedAt, savedUser.getUpdatedAt());

        assertEquals(null, savedUser.getGames());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByEmailFound() {

        userRepository.save(testUser);

        User foundUser = userRepository.findByEmail("admin@adm.com").orElse(null);   

        assertNotNull(foundUser);

        assertNotNull(foundUser.getId());

        assertEquals("admin@adm.com", foundUser.getEmail());

        assertEquals("admin", foundUser.getFullName());
    }
}