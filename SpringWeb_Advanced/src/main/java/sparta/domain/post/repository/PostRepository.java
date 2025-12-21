package sparta.domain.post.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sparta.common.entity.Post;
import sparta.domain.post.model.dto.PostSummaryDto;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // - This Method is Not LAZY
    @Query("""
            SELECT new sparta.domain.post.model.dto.PostSummaryDto(
                        p.content,
                        SIZE(p.comments)
                        ) 
                        FROM Post p 
                        WHERE p.user.username = :username
                        """)
    List<PostSummaryDto> findAllWithCommentsByUsername(@Param("username") String username);

    // - EntityGraph Practice
    @EntityGraph(attributePaths = {"user", "comments"})
    List<Post> findByUserUsername(String username);
}
