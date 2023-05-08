package service;

import com.instagram.instagramclonecoding.domain.user.User;
import com.instagram.instagramclonecoding.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //1.IoC 2. 트랜젝션 관리
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional //write(insert, update, delete할 때)
    public User 회원가입(User user){
        //회원가입 진행
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); //암호화된 pw
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); //권한. 관리자는 ROLE_ADMIN임
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
