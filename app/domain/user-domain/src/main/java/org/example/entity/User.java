package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(name = "nickname", nullable = false)
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }
}