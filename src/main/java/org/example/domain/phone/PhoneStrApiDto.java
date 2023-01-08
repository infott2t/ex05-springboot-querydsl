package org.example.domain.phone;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data

public class PhoneStrApiDto {
    private Long id;

    private String phoneNumber;



    @QueryProjection
    public PhoneStrApiDto( Long id
, String phoneNumber

) {
     this.id = id;

     this.phoneNumber = phoneNumber;



    }
/*Builder,    id().

 phoneNumber().

 a().

*/}