package service;

import com.instagram.instagramclonecoding.domain.user.User;
import com.instagram.instagramclonecoding.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //1.IoC 2. 트랜젝션 관리
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public User 회원가입(User user){
        //회원가입 진행
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
