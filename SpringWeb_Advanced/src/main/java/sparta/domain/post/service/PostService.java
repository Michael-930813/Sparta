package sparta.domain.post.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.common.entity.Post;
import sparta.common.entity.User;
import sparta.domain.post.model.dto.PostDto;
import sparta.domain.post.model.dto.PostSummaryDto;
import sparta.domain.post.repository.PostRepository;
import sparta.domain.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
// - Properties
    private final PostRepository postRepository;
    private final UserRepository userRepository;

// - Methods
    // - Create
    public PostDto createPost(String username, String content) {
        User user = userRepository.findByUsernameByJpql(username).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        Post post = new Post(content, user);

        postRepository.save(post);

        return PostDto.from(post);
    }
    // - Read
    public List<PostDto> getPostListByUsername(String username) {
        // - Find User
        User user = userRepository.findByUsernameByJpql(username).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // - Get PostList
        List<Post> postList = user.getPosts();
        // - Return PostList to PostDtoList
        return postList.stream()
                .map(PostDto::from)
                .toList();
    }
    // - Read - CommentCount
    public List<PostSummaryDto> getPostSummaryListByUsername(String username) {
//        // - Fetch Join Code
//        List<Post> postList = postRepository.findAllWithCommentsByUsername(username);
//
//        return postList.stream()
//                .map(post -> new PostSummaryDto(post.getContent(), post.getComments().size()))
//                .toList();

//        // - N + 1 Problem Code
//        User user = userRepository.findByUsername(username).orElseThrow(
//                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
//        );
//
//        List<PostSummaryDto> result = new ArrayList<>();
//
//        for (Post post : user.getPosts()) {
//            int commentCount = post.getComments().size();
//            result.add(new PostSummaryDto(post.getContent(), commentCount));
//        }
//
//        return result;

        // - BatchSize Code
//        List<Post> postList = postRepository.findByUserUsername(username);
//
//        return postList.stream()
//                .map(post -> new PostSummaryDto(post.getContent(), post.getComments().size()))
//                .toList();


        // - DTO Projection
        List<PostSummaryDto> result = postRepository.findAllWithCommentsByUsername(username);

        return result;
    }
}
