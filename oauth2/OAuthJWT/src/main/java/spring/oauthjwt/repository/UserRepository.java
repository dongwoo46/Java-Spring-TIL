package spring.oauthjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.oauthjwt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

}
