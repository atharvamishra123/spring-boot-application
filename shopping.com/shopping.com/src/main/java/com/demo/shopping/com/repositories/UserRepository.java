package com.demo.shopping.com.repositories;

import com.demo.shopping.com.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findById(int uid);
    Optional<User> findUserByUsername(String username);
}
