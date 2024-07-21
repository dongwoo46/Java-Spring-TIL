package jpabasic.jpabasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class JpabasicApplication {

	public static void main(String[] args) {
		// 엔티티 매니저 팩토리 - 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabasic");
		// 앤티티 매니저 - 생성
		EntityManager em = emf.createEntityManager();
		//트랜잭션 - 획득
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Member member = new Member();
		String id = "id1";
		member.setId(id);
		member.setUsername("지한");
		member.setAge(2);
		em.persist(member);

		em.close();
		emf.close();



//		try {
//			tx.begin(); // 트랙잭션 - 시작
//
//			String id = "id1";
//			Member member = new Member();
//			member.setId(id);
//			member.setUsername("지한");
//			member.setAge(2);
//
//			//등록
//			em.persist(member);
//
//			//수정
//			member.setAge(20);
//
//			//한건 조회 // 비지니스 로직 실행
//			Member findMember = em.find(Member.class, id);
//			System.out.println("findMember = " + findMember.getUsername() + ", age=" +findMember.getAge());
//
//			//목록 조회
//			List<Member> members = em.createQuery("select m from Member m", Member.class)
//							.getResultList();
//			System.out.println("members.size = " + members.size());
//
//
//
//			tx.commit(); // 트랜잭션 - 커밋
//		} catch (Exception e) {
//			tx.rollback(); // 트랜잭션 - 롤백
//		} finally {
//			em.close(); // 엔티티 매니저 - 종료
//		}
//		emf.close(); // 엔티티 매니저 팩토리 - 종료

	}

}
