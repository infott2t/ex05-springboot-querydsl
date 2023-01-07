package org.example.domain.roleclass.guest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.address.AddressStr;
import org.example.domain.phone.PhoneStr;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_GUEST")
public class RoleGUEST {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_GUEST_ID")
    private Long id;


    private LocalDateTime createDate;
}
