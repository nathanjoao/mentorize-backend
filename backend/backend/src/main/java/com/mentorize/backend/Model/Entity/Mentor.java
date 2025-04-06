package com.mentorize.backend.Model.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@SuperBuilder
public class Mentor extends User{


    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, orphanRemoval = true)
    // if delete the mentor, it deletes the career
    private List<MentorCareer> mentorCarrer;

    public void addExperience(MentorCareer mentorCareer) {
        mentorCareer.setMentor(this);
        this.mentorCarrer.add(mentorCareer);
    }

}
