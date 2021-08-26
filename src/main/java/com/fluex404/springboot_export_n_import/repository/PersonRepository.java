package com.fluex404.springboot_export_n_import.repository;

import com.fluex404.springboot_export_n_import.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
