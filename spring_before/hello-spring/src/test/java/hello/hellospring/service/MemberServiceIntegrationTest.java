package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MemberServiceIntegrationTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello1");

        //when
        Long saveId = memberService.join(member);

        // alt + enter : import static method
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

/*
//이러한 에러가 떠야한다!!
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
 */


/*
//try catch로 중복 체크
        try {
            memberService.join(member2);
            fail("예외가 발생해야한다");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        }
 */


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

}
