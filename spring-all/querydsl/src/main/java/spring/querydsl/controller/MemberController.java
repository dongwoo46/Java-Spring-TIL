package spring.querydsl.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.querydsl.dto.MemberSearchCondition;
import spring.querydsl.dto.MemberTeamDto;
import spring.querydsl.repository.MemberJpaRepository;
import spring.querydsl.repository.MemberRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;
    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }
    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition,
                                              Pageable pageable) {
        return memberJpaRepository.searchPageSimple(condition, pageable);
    }
    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition,
                                              Pageable pageable) {

        
        return memberJpaRepository.searchPageComplex(condition, pageable);
    }
}

