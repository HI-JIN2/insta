package com.instagram.instagramclonecoding.config.auth;

import com.instagram.instagramclonecoding.domain.user.User;
import com.instagram.instagramclonecoding.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //IoC
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    //1. 패스워드는 알아서 체킹하니까 신경 쓸 필요 없다.
    //2. 리턴이 잘 되면 자동으로 세션을 만든다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("나 실행돼?"+username);

        User userEntity = userRepository.findByUsername(username);

        if(userEntity==null) {
            return null;
        }else{
            return new PrincipalDetails(userEntity);
        }
    }
}
