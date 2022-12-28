package org.example.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="T_MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_MEMBER_ID")
    private Long id;
    private String username;
    private String password;

    @Builder
    public Member(Long id, String userName, String password) {
        this.id = id;
        this.username = userName;
        this.password = password;
    }

}
