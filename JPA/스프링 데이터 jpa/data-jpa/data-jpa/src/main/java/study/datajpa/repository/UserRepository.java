package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
