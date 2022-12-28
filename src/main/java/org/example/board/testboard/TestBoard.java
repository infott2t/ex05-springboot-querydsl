package org.example.board.testboard;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="TEST_BOARD")
public class TestBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_BOARD_ID")
    private Long id;
    private Long hit;
    private String title;
    private String content;
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;
    LocalDateTime regDate;


    @Builder
    public TestBoard( Long hit, String title, String userName, Member member, LocalDateTime regDate) {
        this.hit = hit;
        this.title = title;
        this.userName = userName;
        this.regDate = regDate;
        this.member = member;
    }
}
