package com.mentorize.backend.Service.User;

import com.mentorize.backend.Model.DTO.Mentor.MentorGetResponseDTO;
import com.mentorize.backend.Model.Entity.Mentor;
import com.mentorize.backend.Model.Entity.MentorCareer;
import com.mentorize.backend.Repository.MentorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MentorService {

    @Autowired
    private final MentorRepository mentorRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public MentorService(MentorRepository mentorRepository, ModelMapper modelMapper) {
        this.mentorRepository = mentorRepository;
        this.modelMapper = modelMapper;

    }

    public void addMentor(Mentor mentor) {
        if (mentor.getMentorCarrer() != null) {
            for (MentorCareer experience : mentor.getMentorCarrer()) {
                experience.checkAndSetEndDate();
                mentor.addExperience(experience);

            }
        }
        mentorRepository.save(mentor);
    }

    public MentorGetResponseDTO getMentor(@PathVariable Integer id){
        Mentor mentor = mentorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Mentor Not Found"));
        return modelMapper.map(mentor, MentorGetResponseDTO.class);
    }

    public void deleteMentor(@PathVariable Integer id) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor not found"));
        mentorRepository.delete(mentor);
    }

}
