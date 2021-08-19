package com.example.sajalniback.Controller;


import com.example.sajalniback.Repository.RoleRepository;
import com.example.sajalniback.Repository.UserRepository;
import com.example.sajalniback.Request.RegisterRequest;
import com.example.sajalniback.Request.UserRequest;
import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.ERole;
import com.example.sajalniback.model.Role;
import com.example.sajalniback.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private   BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleRepository roleRepository;

    public UserController(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    //list
    @RequestMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //detail
    @GetMapping("/find/{id}")

    public ResponseEntity<User> getUsereById(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        log.debug("rest request to get User By Id : {}",id);

        User u = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user does not found for this id :: " + id));

        return ResponseEntity.ok(u);
    }
    //ajout
    @PostMapping("/add")
    public User createUser(@RequestBody UserRequest request) {
        String encodedPassword = bCryptPasswordEncoder .encode(request.getPassword());
        User u = new User(request.getNom(),  encodedPassword, request.getEmail());

        Set<Role> rols = new HashSet<>();
        Role adminRole = roleRepository.findByName(request.getRoles())
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        rols.add(adminRole);
        u.setRoles(rols);
        return userRepo.save(u);

    }
    // update

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userInfo){

        log.debug("rest request to update user with user id : {} and user(requestBody) : {} ",id,userInfo);
        User u = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User does not exist with id :" + id));
        u.setNom(userInfo.getNom());
        User updateduser = userRepo.save(u);
        return ResponseEntity.ok(updateduser);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        User u = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User does not exist with id :" + id));

        userRepo.delete(u);
        Map<String, Boolean> response = new HashMap<>();
        response.put(id+"deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
