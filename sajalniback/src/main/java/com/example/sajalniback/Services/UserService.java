package com.example.sajalniback.Services;

import com.example.sajalniback.Repository.UserRepository;
import com.example.sajalniback.Response.MessageResponse;
import com.example.sajalniback.Security.UserDetailsImpl;
import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
     UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }
    //private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
        User user = ur.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("l'email '" +email+"' n'existe pas" ));
        return UserDetailsImpl.build(user);
    }

}
