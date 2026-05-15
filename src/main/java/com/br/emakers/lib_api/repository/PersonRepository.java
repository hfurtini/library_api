package com.br.emakers.lib_api.repository;

import com.br.emakers.lib_api.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    UserDetails findByEmail(String email);
}
