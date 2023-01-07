package org.example.domain.roleclass.company;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.address.AddressStr;
import org.example.domain.coperation.Coperation;
import org.example.domain.phone.PhoneStr;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_COMPANY")
public class RoleCOMPANY {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_COMPANY_ID")
    private Long id;

    @ManyToOne(targetEntity = AddressStr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressStr addressStr;


    @ManyToOne(targetEntity = PhoneStr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PHONE_STR_ID")
    private PhoneStr phoneStr;

    @ManyToOne(targetEntity = Coperation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "T_COPERATION_ID")
    private Coperation coperation;

    private LocalDateTime createDate;

    public void setAddressStr(AddressStr addressStr0) {
        this.addressStr = addressStr0;
    }

    public void setPhoneStr(PhoneStr phoneStr0) {
        this.phoneStr = phoneStr0;
    }

    @Builder
    public RoleCOMPANY(AddressStr addressStr, PhoneStr phoneStr, Coperation coperation, LocalDateTime createDate) {
        this.addressStr = addressStr;
        this.phoneStr = phoneStr;
        this.coperation = coperation;
        this.createDate = createDate;
    }
}
