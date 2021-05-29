package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 유저_생성() {

        //given
        String user_id = "ccc";
        String user_pw = "ddd";
        userRepository.save(User.builder().userID(user_id).userPassword(user_pw).build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getUserID()).isEqualTo(user_id);
        assertThat(user.getUserPassword()).isEqualTo(user_pw);

    }
}