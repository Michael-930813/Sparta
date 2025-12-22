package org.example.plus.domain.post.repository;

import org.example.plus.common.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>, PostCustomRepository {
// - JPA Query
//    @Query("""
//            SELECT new org.example.plus.domain.post.model.dto.PostSummaryDto(
//            p.content,
//            SIZE(p.comments)
//            )
//            FROM Post p
//            WHERE p.user.username = :username
//            """)
//    List<PostSummaryDto> findAllWithCommentsByUsername(@Param("username") String username);
//
//    @EntityGraph(attributePaths = {"user","comments"})
//    List<Post> findByUserUsername(String username);

}
