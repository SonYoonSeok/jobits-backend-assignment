package jobits.assignment.lmpl;

import jobits.assignment.domain.entity.User;
import jobits.assignment.domain.repository.UserRepository;
import jobits.assignment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServicelmpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void SignUp(User user) {

        userRepository.save(user);
    }

    @Override
    public User SignIn(String id, String pw) throws Exception{
        User user = userRepository.findByUserID(id);
        if (user == null) throw new Exception("존재하지 않는 ID");

        if (!user.getUserPassword().equals(pw)) {
            throw new Exception("비밀번호가 틀립니다.");
        }

        return user;
    }
}
