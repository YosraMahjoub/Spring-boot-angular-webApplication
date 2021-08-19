package com.example.sajalniback.Services;

import com.example.sajalniback.Repository.RoleRepository;
import com.example.sajalniback.Repository.UserRepository;
import com.example.sajalniback.Request.RegisterRequest;
import com.example.sajalniback.Response.MessageResponse;
import com.example.sajalniback.model.ERole;
import com.example.sajalniback.model.Role;
import com.example.sajalniback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegistrationService {


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository ur;
    @Autowired
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<?> register(RegisterRequest request) {
        boolean userExists = ur
                .findByEmail(request.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("l'email "+request.getEmail()+" existe déjà");
        }

        String encodedPassword = bCryptPasswordEncoder .encode(request.getPassword());
        User user = new User(request.getNom(),encodedPassword,request.getEmail());

        Set<Role> roles = new HashSet<>();



        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
        user.setRoles(roles);

        ur.save(user);

        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
         }
}
