package com.likebookapp.service;

import com.likebookapp.init.LoggedUser;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, PostRepository postRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
    }

    public List<Post> getUserContents() {
        return this.postRepository.findAllByCreatorId(loggedUser.getId());
    }

    public void removeContent(Long postId) {

        User user = this.userRepository.findById(this.loggedUser.getId());

        Optional<Post> post = this.postRepository.findById(postId);

        this.postRepository.delete(post.get());
    }
}
