package service;

import com.instagram.instagramclonecoding.domain.subscribe.Subscribe;
import com.instagram.instagramclonecoding.domain.subscribe.SubscribeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void 구독하기(int fromUserId, int toUserId){

        subscribeRepository.mSubscribe(fromUserId,toUserId);
    }


    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId){
        subscribeRepository.mUnSubscribe(fromUserId, toUserId);//m은 내가 만들었따

    }
}
