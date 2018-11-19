package com.example.springclouduser.repository;

import com.example.springclouduser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
    public User findByUsername(String userName);
}
