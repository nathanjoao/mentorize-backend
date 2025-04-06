package com.mentorize.backend.Model.DTO.Mentor;

import com.mentorize.backend.Model.Entity.MentorCareer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class MentorGetResponseDTO {
    @NotBlank
    String name;

    @NotBlank
    Integer age;

    @NotBlank
    String email;

    @NotBlank
    List<MentorCareer> mentorCareer;
}
