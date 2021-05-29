package jobits.assignment.service;

import jobits.assignment.domain.entity.User;

public interface AuthService {

    void SignUp(User user);

    User SignIn(String id, String pw) throws Exception;
}
