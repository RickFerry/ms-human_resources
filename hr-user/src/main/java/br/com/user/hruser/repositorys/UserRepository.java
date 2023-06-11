package br.com.user.hruser.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.user.hruser.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByEmail(String email);
}
