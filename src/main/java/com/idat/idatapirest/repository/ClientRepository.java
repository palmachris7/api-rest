package com.idat.idatapirest.repository;

import com.idat.idatapirest.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Integer> {
}
