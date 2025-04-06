package com.mentorize.backend.Controller.User;

import com.mentorize.backend.Model.DTO.Mentor.MentorGetResponseDTO;
import com.mentorize.backend.Model.Entity.Mentor;
import com.mentorize.backend.Service.User.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
    }

    @GetMapping("/getOne/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MentorGetResponseDTO> getMentor(@PathVariable Integer id){
        MentorGetResponseDTO mentorGetResponseDTO = mentorService.getMentor(id);
        return ResponseEntity.ok(mentorGetResponseDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMentor(@PathVariable Integer id){
        mentorService.deleteMentor(id);
    }

}
