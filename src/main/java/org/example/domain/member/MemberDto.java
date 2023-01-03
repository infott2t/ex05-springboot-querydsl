package org.example.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String userEmail;
    private String password;

    private String role;



    @Builder
    public MemberDto(Long id, String username, String password, String role) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.role = role;
    }



    public Member toEntity() {
        return Member.builder().
                id(id).
                userName(username).
                password(password).
                role(role).
                build();
    }
}
