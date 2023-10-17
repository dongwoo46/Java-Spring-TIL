package study.datajpa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.datajpa.entity.User;
import study.datajpa.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    @Autowired
    private final UserRepository userRepository;

    public boolean login(User user) {

        User findUser = userRepository.findById(user.getUserId());

        if(findUser == null){
            return false;

        }

        if(!findUser.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;

    }

};
