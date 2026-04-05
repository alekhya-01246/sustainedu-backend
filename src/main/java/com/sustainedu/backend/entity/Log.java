package com.sustainedu.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String email;

    @Column
    private String type;

    @Column
    private String time;
}
