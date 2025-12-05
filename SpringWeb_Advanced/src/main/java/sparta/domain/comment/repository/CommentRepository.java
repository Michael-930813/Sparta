package sparta.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.common.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // - Find All
}