package spring.datajpa.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import spring.datajpa.entity.Member;

import java.util.List;

// 쿼리 dsl 사용시 많이 사용
// MemberRepository 뒤에 무조건 ImpL 붙여야함 인터페이스 이름은 상관 X
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final EntityManager em;

//    public MemberRepositoryImpl(EntityManager em) {
//        this.em = em;
//    }

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
