package org.example.repository.artist;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.artist.QArtistGenre.artistGenre;
import static org.example.entity.genre.QGenre.genre;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistQuerydslRepositoryImpl implements ArtistQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ArtistDetailResponse> findAllWithGenreNames() {
        return jpaQueryFactory
            .from(artist)
            .innerJoin(artistGenre)
            .on(artist.id.eq(artistGenre.artistId)
                .and(artistGenre.isDeleted.isFalse()))
            .innerJoin(genre).on(artistGenre.genreId.eq(genre.id)
                .and(genre.isDeleted.isFalse()))
            .where(artist.isDeleted.isFalse())
            .transform(
                groupBy(artist.id).list(
                    Projections.constructor(
                        ArtistDetailResponse.class,
                        artist.id,
                        artist.koreanName,
                        artist.englishName,
                        artist.country,
                        artist.artistGender,
                        artist.artistType,
                        list(genre.name)
                    )
                )
            );
    }

    @Override
    public Optional<ArtistDetailResponse> findArtistWithGenreNamesById(UUID id) {
        return Optional.ofNullable(jpaQueryFactory
            .from(artist)
            .innerJoin(artistGenre)
            .on(artist.id.eq(artistGenre.artistId)
                .and(artistGenre.isDeleted.isFalse()))
            .innerJoin(genre).on(artistGenre.genreId.eq(genre.id)
                .and(genre.isDeleted.isFalse()))
            .where(artist.id.eq(id))
            .where(artist.isDeleted.isFalse())
            .transform(
                groupBy(artist.id).as(
                    Projections.constructor(
                        ArtistDetailResponse.class,
                        artist.id,
                        artist.koreanName,
                        artist.englishName,
                        artist.country,
                        artist.artistGender,
                        artist.artistType,
                        list(genre.name)
                    )
                )
            )
            .get(id)
        );
    }

}
