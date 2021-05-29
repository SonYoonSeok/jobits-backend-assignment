package jobits.assignment.domain.controller;

import jobits.assignment.domain.entity.User;
import jobits.assignment.service.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public Response UserSignUp(@RequestBody User user) {
        Response response = new Response();

        try {
            authService.SignUp(user);
            response.setMessage("회원가입 성공");
        } catch (Exception e) {
            response.setMessage("회원가입 실패");
        }

        return response;
    }
}
