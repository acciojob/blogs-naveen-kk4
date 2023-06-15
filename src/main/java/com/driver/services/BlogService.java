package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public User createAndReturnBlog(Integer userId, String title, String content) {
        Optional<User> userOptional = userRepository1.findById(userId);
        User user = userOptional.get();
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setUser(user);
        blog.setTitle(title);
        blogRepository1.save(blog);
        user.getBlogList().add(blog);
        userRepository1.save(user);
        return user;

    }

    public void deleteBlog(int blogId){
        blogRepository1.deleteById(blogId);
        //delete blog and corresponding images

    }
}
