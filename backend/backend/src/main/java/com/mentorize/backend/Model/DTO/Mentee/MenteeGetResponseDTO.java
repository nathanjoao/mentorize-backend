package com.mentorize.backend.Model.DTO.Mentee;

import com.mentorize.backend.Model.Entity.MenteeInterests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class MenteeGetResponseDTO {

    @NotBlank
    String goals;

    @NotBlank
    String currentOcupation;

    @NotBlank
    List<MenteeInterests> interests;
}
