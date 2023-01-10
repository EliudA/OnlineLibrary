package com.sda.bookstore.project;

import com.sda.bookstore.project.model.User;
import com.sda.bookstore.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("josh");
        user.setPassword("qwerty");
        user.setFirstName("John");
        user.setLastName("Ochieng");
        user.setEmail("jochieng@gmail.com");
        user.setPhone("789654");
        user.setEnabled(true);

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

       // assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
