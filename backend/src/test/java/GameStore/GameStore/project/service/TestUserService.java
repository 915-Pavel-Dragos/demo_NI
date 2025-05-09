package GameStore.GameStore.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import GameStore.GameStore.project.model.User;
import GameStore.GameStore.project.repository.UserRepository;
import jakarta.transaction.Transactional;

@ExtendWith(MockitoExtension.class)
public class TestUserService {
    
    private User testUser;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    
    private static final Date createdAt = new Date(System.currentTimeMillis());
    private static final Date updatedAt = new Date(System.currentTimeMillis());

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
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
    public void numberOfUsers() { 
        // This list mocks the expected returned value for the userService.allUsers() call
        List<User> expected_users = new ArrayList<>();
        expected_users.add(testUser);

        assertEquals(0, userService.allUsers().size());

        when(userService.allUsers()).thenReturn(expected_users);

        assertEquals(1, userService.allUsers().size());
    }
}