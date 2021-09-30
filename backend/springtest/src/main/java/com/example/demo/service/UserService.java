package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.AuthUserDetails;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.UserView;
import com.example.demo.respository.StudentRepository;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void insert(User user) {
        userRepository.save(user);
    }


    public UserView getSessionUser() throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.getByUserNameUserView(authentication.getName()).orElseThrow(() -> new UnauthorizedException());
    }

    @Transactional
    public User getById(Long id) { return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)); }

    @Transactional
    public void updateById(Long Id, User user) {
        User existingUser = userRepository.findById(Id).orElse(new User());
        user.setId(existingUser.getId());
        userRepository.save(user);
    }

    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
