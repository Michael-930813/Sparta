package org.example.plus.domain.post.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.plus.domain.post.model.dto.PostSummaryDto;

import java.util.List;

import static org.example.plus.common.entity.QComment.comment;
import static org.example.plus.common.entity.QPost.post;
import static org.example.plus.common.entity.QUser.user;

public class PostCustomRepositoryImpl implements PostCustomRepository{
// - Properties
    private final JPAQueryFactory queryFactory;


// - Methods
    // - Constructor
    public PostCustomRepositoryImpl(EntityManager em) { queryFactory = new JPAQueryFactory(em); }

    // - QueryMethods
    @Override
    public List<PostSummaryDto> finPostSummary(String username) {
        return queryFactory
                .select(Projections.constructor(
                        PostSummaryDto.class,
                        post.content,
                        comment.countDistinct().intValue()
                ))
                .from(post)
                .leftJoin(user).on(post.userId.eq(user.id))
                .leftJoin(comment).on(comment.postId.eq(post.id))
                .where(user.username.eq(username))
                .groupBy(post.id)
                .fetch();
    }
}
