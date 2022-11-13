package mini.springboard.domain;

import lombok.Getter;

@Getter
// 열거자료형(enum) 으로 작성
public enum UserRole {

    ADMIN("ROLE_ADMIN"),

    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;

}
