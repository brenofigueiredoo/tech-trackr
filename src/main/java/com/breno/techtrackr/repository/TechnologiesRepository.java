package com.breno.techtrackr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.breno.techtrackr.model.Technologies;

// JpaRepository<Technologies, Long>
// Primeiro parametro é a model que deseja acessar
// Segundo parametro é o type do id, Long com L Upper Case

public interface TechnologiesRepository extends JpaRepository<Technologies, Long> {

    boolean existsTechnologieByName(String name);

}
