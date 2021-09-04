package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    @SequenceGenerator(
            name = "post_seq",
            sequenceName = "post_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq"
    )
    private Long id;
    private int userId;
    private String title;
    private String body;

    public Posts(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
