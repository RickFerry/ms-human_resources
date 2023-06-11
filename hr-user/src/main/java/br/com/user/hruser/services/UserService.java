package br.com.user.hruser.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.user.hruser.models.User;
import br.com.user.hruser.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found."));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User with email: " + email + " not found."));
    }
}
