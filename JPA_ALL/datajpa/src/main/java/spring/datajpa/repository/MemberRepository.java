package spring.datajpa.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import spring.datajpa.dto.MemberDto;
import spring.datajpa.entity.Member;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

// MemberRepositoryCustom, JpaRepository 상속받아야함
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age=:age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);


    @Query("select m.username from Member m")
    List<String> findusernameList();

//
    @Query("select new spring.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();
//
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);
//
    List<Member> findListByUsername(String username); // 컬렉션
    Member findMemberByUsername(String username);// 단건
    Optional<Member> findOptinalByUsername(String username);// 단건 optional
//
    Page<Member> findByAge(int age, Pageable pageable);

    Slice<Member> findSliceByAge(int age, Pageable pageable); // limit +1 -> 더보기

//
    @Modifying(clearAutomatically = true) // 영속성 컨텍스트 clear bulk연산은 db에 바로 때려서 영속성 컨텍스트에는 반영x있어서 clear해줌
    @Query("update Member m set m.age=m.age +1 where m.age>=:age")
    int bulkAgePlus(@Param("age") int age);
//
    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    //공통 메서드 오버라이드 -> 페치조인 할때 씀(jpql 쓰지않고 바로하려면)
    @Override
    @EntityGraph(attributePaths = {"team"}) // 페치조인 때 사용
    List<Member> findAll();

    //JPQL + 엔티티 그래프 -> 페치조인 추가하는거임
    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

    //메서드 이름으로 쿼리에서 특히 편리하다. team을 페치조인
    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(String username);

     // 변경감지 안할거야 읽기만 할거야!! -> 메모리최적화
    // 변경감지 작동 x, set해도 업데이트 쿼리 나가지 않음
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);

    //select for update
    // db lcok
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);


}
