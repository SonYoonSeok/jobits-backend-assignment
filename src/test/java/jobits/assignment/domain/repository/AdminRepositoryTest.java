package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.Admins;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @AfterEach
    public void cleanup() {
        adminRepository.deleteAll();
    }

    @Test
    public void 어드민_생성() {

        //given
        String admin_id = "aaa";
        String admin_pw = "bbb";
        adminRepository.save(Admins.builder().adminID(admin_id).adminPassword(admin_pw).build());

        //when
        List<Admins> adminList = adminRepository.findAll();

        //then
        Admins admin = adminList.get(0);
        assertThat(admin.getAdminID()).isEqualTo(admin_id);
        assertThat(admin.getAdminPassword()).isEqualTo(admin_pw);
    }
}