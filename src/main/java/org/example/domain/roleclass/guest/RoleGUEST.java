package org.example.domain.roleclass.guest;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_GUEST")
public class RoleGUEST {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_GUEST_ID")
    private Long id;
}
