package com.sts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
