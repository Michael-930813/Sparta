package org.example.springweb_jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserReposigory userReposigory;

// - Create
    @Transactional
    public void save() {
        User user = new User("김재환", "un8265@gmail.com", "서울");
        userReposigory.save(user);
    }

// - Read
    // - GetOne
    @Transactional(readOnly = true)
    public void getOne() {
        User user = userReposigory.findById(1L).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
    }
    // - GetAll
    @Transactional(readOnly = true)
    public void getAll() {
        List<User> users = userReposigory.findAll();
    }

// - Update
    @Transactional
    public void update() {
        User user = userReposigory.findById(1L).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        user.update("김공공", "bye@gmail.com", "경기도");
    }

// - Delete
    @Transactional
    public void delete() {
        boolean existence = userReposigory.existsById(1L);
        // - Is Null
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        userReposigory.deleteById(1L);
    }
}