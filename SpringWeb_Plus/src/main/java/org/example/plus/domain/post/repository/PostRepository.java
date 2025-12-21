package org.example.plus.domain.post.repository;

import java.util.List;
import org.example.plus.common.entity.Post;
import org.example.plus.domain.post.model.dto.PostSummaryDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post,Long>, PostCustomRepository {

    @Query("""
            SELECT new org.example.plus.domain.post.model.dto.PostSummaryDto(
            p.content,
            SIZE(p.comments)
            ) 
            FROM Post p 
            WHERE p.user.username = :username
            """)
    List<PostSummaryDto> findAllWithCommentsByUsername(@Param("username") String username);

    @EntityGraph(attributePaths = {"user","comments"})
    List<Post> findByUserUsername(String username);

}
