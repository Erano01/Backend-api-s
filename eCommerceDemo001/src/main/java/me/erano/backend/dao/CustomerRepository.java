package me.erano.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import me.erano.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
