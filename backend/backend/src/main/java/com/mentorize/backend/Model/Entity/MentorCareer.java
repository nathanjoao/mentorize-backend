package com.mentorize.backend.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorCareer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @Column(nullable = false)
    private String role;

    private String description;

    private boolean current;

    private java.time.LocalDate startDate;

    private java.time.LocalDate endDate;

    public void checkAndSetEndDate(){
        if (Boolean.TRUE.equals(this.current)){
            this.endDate = null;
        }
    }




}
