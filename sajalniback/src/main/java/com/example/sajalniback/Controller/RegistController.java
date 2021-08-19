package com.example.sajalniback.Controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.sajalniback.Repository.UserRepository;
import com.example.sajalniback.Request.LoginRequest;
import com.example.sajalniback.Request.RegisterRequest;
import com.example.sajalniback.Response.JwtResponse;
import com.example.sajalniback.Security.JWT.JwtUtils;
import com.example.sajalniback.Security.UserDetailsImpl;
import com.example.sajalniback.Services.RegistrationService;

import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class RegistController {
    private final Logger log = LoggerFactory.getLogger(RegistController.class);
    @Autowired
    AuthenticationManager authenticationManager;
static User currentUser;
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;


    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RegistrationService rs;

    public RegistController(UserRepository userRepo, RegistrationService rs) {
        this.userRepo = userRepo;
        this.rs = rs;
    }

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegisterRequest request) {
        return rs.register(request);
    }

     @PostMapping("/signin")
     public ResponseEntity<JwtResponse> login( @RequestBody LoginRequest loginRequest) {

         Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
         String jwt = jwtUtils.generateJwtToken(authentication);

         UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

         List<String> roles = userDetails.getAuthorities().stream()
                 .map(item -> item.getAuthority())
                 .collect(Collectors.toList());

         UserDetailsImpl test = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

         currentUser = userRepo.findById(test.getId())
                 .orElseThrow(() -> new UserNotFoundException("user :" + test.getId()+ " n'existe pas"));;

                 log.info("///// currentUser id is  {}  //// ",currentUser.getId()
         );

         return ResponseEntity.ok(
                 new JwtResponse(jwt,
                         userDetails.getId(),
                         userDetails.getNom(),
                         userDetails.getUsername(),
                         roles,
                         userDetails.getPassword(),
                         userDetails.getDate()
                        )  );
     }



}
