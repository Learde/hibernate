package com.example.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientORM extends JpaRepository<Client, Integer> {
}
