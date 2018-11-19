package com.example.springcloud.oauth2.repository;

import com.example.springcloud.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
    public User findByUsername(String userName);
}
