package org.example.domain.roleclass.guest;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class RoleGUESTApiDto {
    private Long id;

    private String a;

    private LocalDateTime createDate;

    @QueryProjection
    public RoleGUESTApiDto( Long id
, String a
, LocalDateTime createDate
) {
     this.id = id;

     this.a = a;

     this.createDate = createDate;


    }
/*Builder,    id().

 a().

 createDate().

*/}