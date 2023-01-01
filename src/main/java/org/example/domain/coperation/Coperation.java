package org.example.domain.coperation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@Table(name="T_COPERATION")
public class Coperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_COPERATION_ID")
    private Long id;

    private String coperationName;  //협력사명

    private String catchPrice;  //캐치프레이즈 예)  김치를 만들어보세요, 반조리음식. 이 일은 어떤가요.

    private LocalDateTime crateDate;    //  생성일

}
