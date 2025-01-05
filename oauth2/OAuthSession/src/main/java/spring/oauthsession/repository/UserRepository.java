package spring.oauthsession.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.oauthsession.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
