package me.EranoMarket.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import me.EranoMarket.com.model.User;


public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String name);
}
