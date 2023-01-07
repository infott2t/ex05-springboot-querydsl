package org.example.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Setter


@Entity
public class AddressStr  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    //우편번호
    private String zipCode;
    //도로명 주소
    private String addr1;
    //상세 주소
    private String addr2;

    @Builder
    public AddressStr(String zipCode, String addr1, String addr2) {

        this.zipCode = zipCode;
        this.addr1 = addr1;
        this.addr2 = addr2;
    }

    public AddressStr() {

    }
}
