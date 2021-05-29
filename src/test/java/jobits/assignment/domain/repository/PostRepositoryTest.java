package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.Admins;
import jobits.assignment.domain.entity.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AdminRepository adminRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
        adminRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        //given
        String admin_id = "aaa";
        String admin_pw = "bbb";
        adminRepository.save(Admins.builder().adminID(admin_id).adminPassword(admin_pw).build());

        String title = "test";
        String text = "test_";
        postRepository.save(Post.builder().postTitle(title).postText(text).adminID(admin_id).build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getPostTitle()).isEqualTo(title);
        assertThat(post.getPostText()).isEqualTo(text);

    }
}