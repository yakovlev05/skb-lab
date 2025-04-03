package ru.yakovlev05.school.skblab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<EventEntity> events = new HashSet<>();

    public TaskEntity(String name, Set<EventEntity> events) {
        this.name = name;
        this.events = events;
    }
}
