package com.kargokart.kargo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kargokart.kargo2.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findBypassword(String password);

}
