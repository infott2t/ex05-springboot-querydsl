package org.example.domain.form.mypage;

public enum RoleRadioItemType {

    GUEST("손님"), USER("사용자"), COMPANY("기업회원"), ADMIN("관리자");

    private final String description;

    RoleRadioItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
