package com.mentorize.backend.Service.User;

import com.mentorize.backend.Model.DTO.Mentee.MenteeGetResponseDTO;
import com.mentorize.backend.Model.Entity.Mentee;
import com.mentorize.backend.Repository.MenteeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MenteeService {

    @Autowired
    private final MenteeRepository menteeRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public MenteeService(MenteeRepository menteeRepository, ModelMapper modelMapper) {
        this.menteeRepository = menteeRepository;
        this.modelMapper = modelMapper;
    }

    public void addMentee(Mentee mentee) {
        menteeRepository.save(mentee);
    }

    public MenteeGetResponseDTO getMentee(@PathVariable Integer id) {
        Mentee mentee = menteeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Mentee not found"));
        return modelMapper.map(mentee, MenteeGetResponseDTO.class);
    }

    public void deleteMentee(@PathVariable Integer id) {
        menteeRepository.deleteById(id);
    }


}
