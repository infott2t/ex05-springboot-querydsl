package org.example.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.domain.BaseTimeEntity;
import org.example.domain.roleclass.admin.RoleADMIN;
import org.example.domain.roleclass.company.RoleCOMPANY;
import org.example.domain.roleclass.guest.RoleGUEST;
import org.example.domain.roleclass.user.RoleUSER;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @ManyToOne(targetEntity = RoleGUEST.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_GUEST_ID")
    private RoleGUEST roleGuest;

    @ManyToOne(targetEntity = RoleUSER.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_USER_ID")
    private RoleUSER roleUser;

    @ManyToOne(targetEntity = RoleCOMPANY.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_COMPANY_ID")
    private RoleCOMPANY roleCompany;

    @ManyToOne(targetEntity = RoleADMIN.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ADMIN_ID")
    private RoleADMIN roleAdmin;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
