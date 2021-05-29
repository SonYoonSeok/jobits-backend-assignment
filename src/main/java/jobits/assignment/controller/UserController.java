package jobits.assignment.controller;

import jobits.assignment.config.Security.JwtTokenProvider;
import jobits.assignment.domain.entity.User;
import jobits.assignment.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .id(user.get("id"))
                .password(passwordEncoder.encode(user.get("password")))
                .build()).getId();
    }

    @PostMapping("/signin")
    public String signin(@RequestBody Map<String, String> user) {
        User member = userRepository.findByUserID(user.get("id"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));

        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
