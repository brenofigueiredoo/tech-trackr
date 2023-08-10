package com.breno.techtrackr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.breno.techtrackr.model.Technologies;
import com.breno.techtrackr.model.User;

// JpaRepository<User, Long>
// Primeiro parametro é a model que deseja acessar
// Segundo parametro é o type do id, Long com L Upper Case

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);

    UserDetails findByEmail(String email);

    @Query("SELECT t FROM User u JOIN u.technologies t WHERE u.id = :userId")
    List<Technologies> findTechnologiesByUserId(long userId);

}
