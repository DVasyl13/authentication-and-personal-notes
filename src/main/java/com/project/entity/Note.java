package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notes")
@Setter @Getter
@ToString(exclude = "user")
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
}
