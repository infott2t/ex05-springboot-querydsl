package org.example.domain.serv.workplan;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.domain.coperation.Coperation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@Table(name="T_WORKPLAN")
public class WorkPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_WORKPLAN_ID")
    private Long id;    //아이디


    //private String workPlanCooperation; //협력사

    @ManyToOne(targetEntity = Coperation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "T_COPERATION_ID")
    private Coperation coperation; //협력사


    private String workPlanTitle;  //제목

    private String workPlanTag; //태그

    private LocalDateTime workPlanStartDate;    //시작일

    private LocalDateTime crateDate;    //  생성일

    private LocalDateTime updateDate; //  수정일

    private String workPlanStatus;  //상태 N인 경우, 서비스 중단의 경우.


    //private ServView servView;  //서비스 뷰 보기버튼을 눌렸을 때.


}
