package org.example.domain.roleclass.admin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.address.AddressStr;
import org.example.domain.phone.PhoneStr;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_ADMIN")
public class RoleADMIN  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ADMIN_ID")
    private Long id;

    @ManyToOne(targetEntity = AddressStr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressStr addressStr;


    @ManyToOne(targetEntity = PhoneStr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PHONE_STR_ID")
    private PhoneStr phoneStr;

    private LocalDateTime createDate;


    public void setAddressStr(AddressStr addressStr0) {
        this.addressStr = addressStr0;
    }

    public void setPhoneStr(PhoneStr phoneStr0) {
        this.phoneStr = phoneStr0;
    }
    @Builder
    public RoleADMIN(AddressStr addressStr, PhoneStr phoneStr, LocalDateTime createDate) {
        this.addressStr = addressStr;
        this.phoneStr = phoneStr;
        this.createDate = createDate;
    }
}
