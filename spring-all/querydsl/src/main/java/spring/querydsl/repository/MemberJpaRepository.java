package spring.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.querydsl.entity.Member;

import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    List<Member> findByUsername(String member1);



}
