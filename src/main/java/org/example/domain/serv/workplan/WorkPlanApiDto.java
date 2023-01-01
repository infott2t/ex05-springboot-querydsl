package org.example.domain.serv.workplan;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import org.example.domain.coperation.Coperation;

import java.time.LocalDateTime;

@Data
public class WorkPlanApiDto {
    private Long id    ;

   // private String workPlanCooperation;
    private Coperation coperation;
    private String workPlanTitle ;
    private String workPlanTag ;
    private String workPlanStatus ;

    private LocalDateTime workPlanStartDate  ;
    private LocalDateTime crateDate    ;
    private LocalDateTime updateDate ;

    @QueryProjection
    public WorkPlanApiDto( Long id    
, Coperation coperation, String workPlanTitle , String workPlanTag , String workPlanStatus
, LocalDateTime workPlanStartDate  , LocalDateTime crateDate    , LocalDateTime updateDate 
) {
     this.id     = id    ;

     this.coperation = coperation;
     this.workPlanTitle  = workPlanTitle ;
     this.workPlanTag  = workPlanTag ;
     this.workPlanStatus  = workPlanStatus ;

     this.workPlanStartDate   = workPlanStartDate  ;
     this.crateDate     = crateDate    ;
     this.updateDate  = updateDate ;


    }
/*Builder,    id    ().

 workPlanCooperation().
 workPlanTitle ().
 workPlanTag ().
 workPlanStatus ().

 workPlanStartDate  ().
 crateDate    ().
 updateDate ().

*/}