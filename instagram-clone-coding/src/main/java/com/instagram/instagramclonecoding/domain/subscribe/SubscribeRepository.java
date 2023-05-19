package com.instagram.instagramclonecoding.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe,Integer> {

    @Modifying
    @Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true)
    void mSubscribe(int fromUserid, int toUserId); //리턴 1, -1 변경된 행의 개수 많큼. 10일수도 있지~ -1는 오류. 0은 변경된 행 x
    //근데 리턴 없애버림
    //

    @Modifying // 데이터베이스에 변경을 주는 어노테이션. INSERT, DELETEm UPDATE를 네이티브 쿼리로 작성하려면 필요
    @Query(value = "DELETE INTO subscribe WHERE fromUserId :=fromUserId AND toUserId =:toUserID", nativeQuery = true)
    void mUnSubscribe(int fromUserid, int toUserId); //1, -1

}
