package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.Post;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void clean() {
        postRepository.deleteAll();
    }

    //given
    @Test
    public void 게시글저장_불러오기() {
        String title = "test";
        String text = "test_";
        postRepository.save()

        //when

        //then
    }
}