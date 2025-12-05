package sparta.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.common.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
