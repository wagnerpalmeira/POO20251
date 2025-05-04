package com.example.roomreservationapp.repository;

import com.example.roomreservationapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
