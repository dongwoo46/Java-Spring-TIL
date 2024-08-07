package spring.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.datajpa.dto.MemberDto;
import spring.datajpa.entity.Member;
import spring.datajpa.repository.MemberRepository;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    // 도메인 클래스 컨버터 사용
    @GetMapping("/members2/{id}")
    public String findMember(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    //localhost:8080/members?page=0&size-3&sort=username,desc
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5,sort="username") Pageable pageable) {
//        PageRequest request = PageRequest.of(1, 2); Pageable이 만들어줌 => 커스텀해서 쓸때 ex) page를 1부터 시작

        Page<Member> page = memberRepository.findAll(pageable);
        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(),member.getUsername(),null));
//        Page<MemberDto> map = page.map(member -> new MemberDto(member));
//      Page<MemberDto> map = page.map(MemberDto::new);
        return map;
    }


//    @PostConstruct
//    public void init() {
//        for (int i = 0; i < 100; i++) {
//            memberRepository.save(new Member("user" + i, i));
//        }
//    }
}
