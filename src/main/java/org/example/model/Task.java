package org.example.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "Task",schema = "challenge")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private Long priority;


    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription( String description) {
        this.description = description;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
