package org.example.domain.roleclass.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_ADMIN")
public class RoleADMIN {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ADMIN_ID")
    private Long id;


}
