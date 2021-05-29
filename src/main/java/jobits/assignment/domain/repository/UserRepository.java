package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserID(String userID);
}
