package org.example.plus.domain.post.repository;


import org.example.plus.common.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post,Long>, PostCustomRepository {


}
