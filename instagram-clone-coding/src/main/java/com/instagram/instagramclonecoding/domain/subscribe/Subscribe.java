package com.instagram.instagramclonecoding.domain.subscribe;

import com.instagram.instagramclonecoding.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name="suscribe_uk",
                        columnNames = {"fromUserId","toUserId"}
                )
        }
)
public class Subscribe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name="fromUserId") //이렇게 컬럼명 만들어! 니 마음대로 만들지 말고!
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser; //ORM

    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
