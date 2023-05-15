package service;

import com.instagram.instagramclonecoding.domain.subscribe.Subscribe;
import com.instagram.instagramclonecoding.domain.subscribe.SubscribeRepository;
import com.instagram.instagramclonecoding.handler.ex.CustomApiException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void 구독하기(int fromUserId, int toUserId){
        try{
            subscribeRepository.mSubscribe(fromUserId,toUserId);

        }catch (Exception e) {
            throw new CustomApiException("이미 구독을 하였습니다.");
        }
    }


    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId){
        subscribeRepository.mUnSubscribe(fromUserId, toUserId);//m은 내가 만들었따
        //삭제는 오류 안남!
    }
}
