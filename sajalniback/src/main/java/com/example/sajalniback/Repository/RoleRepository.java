package com.example.sajalniback.Repository;

import com.example.sajalniback.model.ERole;
import com.example.sajalniback.model.Role;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(ERole name);

}
