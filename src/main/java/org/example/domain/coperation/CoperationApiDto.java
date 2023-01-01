package org.example.domain.coperation;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class CoperationApiDto {
    private Long id;

    private String coperationName  ;
    private String catchPrice  ;
    private LocalDateTime crateDate    ;

    @QueryProjection
    public CoperationApiDto( Long id
, String coperationName  , String catchPrice  , LocalDateTime crateDate
) {
     this.id    = id;
     this.coperationName   = coperationName  ;
     this.catchPrice   = catchPrice  ;
     this.crateDate     = crateDate    ;

    }


/*Builder,    id().

 coperationName  ().

 crateDate    ().

*/}