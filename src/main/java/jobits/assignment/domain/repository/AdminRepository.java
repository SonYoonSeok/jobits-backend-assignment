package jobits.assignment.domain.repository;

import jobits.assignment.domain.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admins, String> {
}
