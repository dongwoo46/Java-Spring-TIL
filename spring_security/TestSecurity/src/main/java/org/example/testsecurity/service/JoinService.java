package org.example.testsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.testsecurity.dto.JoinDTO;
import org.example.testsecurity.entity.UserEntity;
import org.example.testsecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        if (userRepository.existsByUsername(joinDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        // db에 동일한 username 있는지 확인
        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        // security에서 role에 대해 역할을 줄때 ROLE_을 붙여야한다 이건 접두사로 설정되어있다.
        /*
        추가로 ROLE_ 접두사를 변경하시고 싶으면 아래 메소드를 @Bean으로 등록하시면 됩니다.
        @Bean
        static GrantedAuthorityDefaults grantedAuthorityDefaults() {
            return new GrantedAuthorityDefaults("MYPREFIX_");
        }
         */
        data.setRole("ROLE_ADMIN");



        userRepository.save(data);
    }
}
