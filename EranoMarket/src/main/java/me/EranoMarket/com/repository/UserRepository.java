package me.EranoMarket.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.EranoMarket.com.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
