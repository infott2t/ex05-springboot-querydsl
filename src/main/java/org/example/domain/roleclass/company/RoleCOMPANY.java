package org.example.domain.roleclass.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.coperation.Coperation;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ROLE_COMPANY")
public class RoleCOMPANY {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_COMPANY_ID")
    private Long id;

    @ManyToOne(targetEntity = Coperation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "T_COPERATION_ID")
    private Coperation coperation;

}
