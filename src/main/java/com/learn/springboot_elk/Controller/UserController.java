package com.learn.springboot_elk.Controller;

import com.learn.springboot_elk.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUSerById(@PathVariable String id) {
        Long userId;
        try {
            userId = Long.parseLong(id);
        } catch (NumberFormatException numberFormatException) {
            String message = String.format("Invalid user id: %s. Please enter a valid numeric value.", id);
            log.error(message);
            return ResponseEntity.badRequest().body(message);
        }

        log.info("Request with the id= [{}]", userId);
        final User user = new User(userId, "name" + userId, LocalDateTime.now());
        log.info("Retrieve data user id= [{}]", userId);

        return ResponseEntity.ok(user);
    }
}
