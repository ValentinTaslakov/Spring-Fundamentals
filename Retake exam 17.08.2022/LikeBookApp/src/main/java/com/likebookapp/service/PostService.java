package com.likebookapp.service;

import com.likebookapp.init.LoggedUser;
import com.likebookapp.model.dtos.PostAddDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private MoodRepository moodRepository;
    private LoggedUser loggedUser;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, MoodRepository moodRepository, LoggedUser loggedUser, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.moodRepository = moodRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(PostAddDTO postAddDTO) {

        Mood mood = moodRepository.findByName(postAddDTO.getMoodType());
        Optional<User> creator = userRepository.findByUsername(loggedUser.getUsername());

        Post newPost = new Post();

        newPost.setCreator(creator.get());
        newPost.setMood(mood);
        newPost.setContent(postAddDTO.getContent());

        postRepository.save(newPost);


        return true;
    }

    public List<Post> getOtherPost() {

        return this.postRepository.findAllByCreatorIdNot(loggedUser.getId());
    }

    public void addLike(Long postId) {

        User user = this.userRepository.findById(loggedUser.getId());

        Optional<Post> post = this.postRepository.findById(postId);

        if (!post.get().getUsersLikes().contains(user)){
            post.get().setUsersLikes(user);
            this.postRepository.save(post.get());
        }

    }
}
