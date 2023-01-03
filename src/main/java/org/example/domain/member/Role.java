package org.example.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),

    COMPANY("ROLE_COMPANY"),
    MEMBER("ROLE_MEMBER");

    private String value;
}
