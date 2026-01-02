package org.example.plus.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.plus.domain.post.model.dto.PostDto;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PostCacheService {
// - Properties
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String CACHE_POST_PREFIX = "post:";
    private static final String RANKING_POST_KEY = "ranking:posts";


// - Methods
    // - Get Cache
    public PostDto getPostCache(Long postId) {
        String key = CACHE_POST_PREFIX + postId;
        return (PostDto) redisTemplate.opsForValue().get(key);
    }
    // - Save Cache
    public void savePostCache(Long postId, PostDto postDto) {
        String key = CACHE_POST_PREFIX + postId;
        redisTemplate.opsForValue().set(key, postDto, 10, TimeUnit.MINUTES);
    }
    // - Delete Cache
    public void deletePostCache(Long postId) {
        String key = CACHE_POST_PREFIX + postId;
        redisTemplate.delete(key);
    }

    // - Increase the Number of views of viewed posts
    public void increaseViewCount(Long postId) {
        redisTemplate.opsForZSet().incrementScore(RANKING_POST_KEY, postId.toString(), 1);
    }
    // - View popular posts (limit Count)
    public List<Long> getTopPostList(Integer limit) {
        Set<Object> postIdList = redisTemplate.opsForZSet().reverseRange(RANKING_POST_KEY, 0, limit);

        if (postIdList == null || postIdList.isEmpty()) {
            return Collections.emptyList();
        }

        // - Object -> String -> Long
        return postIdList.stream()
                .map(id -> Long.parseLong(id.toString()))
                .toList();
    }
}
