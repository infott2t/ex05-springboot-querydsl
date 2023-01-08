package org.example.domain.address;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data

public class AddressStrApiDto {
    private Long id;

    private String zipCode;
    private String addr1;
    private String addr2;



    @QueryProjection
    public AddressStrApiDto( Long id
, String zipCode, String addr1, String addr2

) {
     this.id = id;

     this.zipCode = zipCode;
     this.addr1 = addr1;
     this.addr2 = addr2;




    }
/*Builder,    id().

 zipCode().
 addr1().
 addr2().

 a().

*/}