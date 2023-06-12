package br.com.oauth.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.oauth.hroauth.feignclients.UserFeignClient;
import br.com.oauth.hroauth.models.User;
import lombok.RequiredArgsConstructor;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        if (userFeignClient.findByEmail(email).getBody() == null) {
            throw new IllegalArgumentException("User with this email: " + email + " not found.");
        }
        return userFeignClient.findByEmail(email).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userFeignClient.findByEmail(username).getBody() == null) {
            throw new UsernameNotFoundException("User with this username: " + username + " not found.");
        }
        return userFeignClient.findByEmail(username).getBody();
    }
}
