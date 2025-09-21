package com.learn.springboot_elk.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private LocalDateTime birthDetails;
}
