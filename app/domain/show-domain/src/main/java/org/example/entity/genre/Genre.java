package org.example.entity.genre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_genre")
public class Genre extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Builder
    private Genre(String name) {
        this.name = name;
    }

    public void updateGenre(String name) {
        this.name = name;
    }
}
