package br.com.user.hruser.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.hruser.models.User;
import br.com.user.hruser.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id){
        return ResponseEntity.ok(userService.getOne(id));
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
