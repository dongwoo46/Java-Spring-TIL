package spring.db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.db.entity.Member;
import spring.db.repository.MemberRepositoryV1;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid fromMember ID: " + fromId));
        Member toMember = memberRepository.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid toMember ID: " + toId));


        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);



    }

    private void validation(Member toMember) {

        if (toMember.getId().equals("ex")) {
            throw new IllegalStateException("이체중 에외 발생");
        }
    }


}
