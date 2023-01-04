package org.example.domain.roleclass.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_USER")
public class RoleUSER {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_USER_ID")
    private Long id;
}
