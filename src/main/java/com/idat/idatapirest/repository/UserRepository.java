package com.idat.idatapirest.repository;

import com.idat.idatapirest.model.Suppliers;
import com.idat.idatapirest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsuario(String usuario);
}
