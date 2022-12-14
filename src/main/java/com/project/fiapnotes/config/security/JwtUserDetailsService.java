package com.project.fiapnotes.config.security;

import com.project.fiapnotes.models.UserModel;
import com.project.fiapnotes.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findFirstByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new User(user.getUsername(),
                user.getPassword(),
                new ArrayList<>());
    }
}
