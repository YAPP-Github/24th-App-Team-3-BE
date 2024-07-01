package org.example.repository.user;

import static org.example.entity.QUser.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQuerydslRepositoryImpl implements UserQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<String> findNicknameById(UUID id) {
        return Optional.ofNullable(jpaQueryFactory
            .select(user.nickname)
            .from(user)
            .where(user.id.eq(id))
            .fetchOne()
        );
    }

}
