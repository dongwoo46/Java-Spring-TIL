package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.User;
import study.datajpa.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/login")
    public String loginId(@ModelAttribute User user) {
        if(loginService.login(user)){
            return "redirect:/";
        }
        return "login";
    }
}
