package sparta.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sparta.common.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // - This Method is Not LAZY
    @Query("SELECT p FROM Post p JOIN FETCH p.comments WHERE p.user.username = :username")
    List<Post> findAllWithCommentsByUsername(@Param("username") String username);
}
