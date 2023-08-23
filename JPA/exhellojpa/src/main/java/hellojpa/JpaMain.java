package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /** create
             * Member member = new Member();
             * member.setId(2L);
             * member.setName("HelloB");
             * em.persist(member);
             */

            /** 조회
             *  Member findMember = em.find(Member.class, 1L);
             */

            /** 삭제
             * Member findMember = em.find(Member.class, 1L);
             * em.remove(findMember)
             */

            /** 수정
             *  Member findMember = em.find(Member.class, 1L);
             *  findMember.setName("helloJPA");
             */

            /**
             * 전체조회
             * List<Member> result = em.createQuery("select m from Member as m", Member.class)
             * .getResultList();
             */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
