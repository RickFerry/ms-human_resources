package br.com.oauth.hroauth.services;

import org.springframework.stereotype.Service;

import br.com.oauth.hroauth.feignclients.UserFeignClient;
import br.com.oauth.hroauth.models.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        if (userFeignClient.findByEmail(email).getBody() == null) {
            throw new IllegalArgumentException("User with this email: " + email + " not found.");
        }
        return userFeignClient.findByEmail(email).getBody();
    }
}
