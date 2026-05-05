package com.br.emakers.lib_api.repository;

import com.br.emakers.lib_api.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
