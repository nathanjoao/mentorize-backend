package com.mentorize.backend.Controller.User;

import com.mentorize.backend.Model.DTO.Mentee.MenteeGetResponseDTO;
import com.mentorize.backend.Model.Entity.Mentee;
import com.mentorize.backend.Service.User.MenteeService;
import com.mentorize.backend.Service.User.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentee")
public class MenteeController {

    @Autowired
    private final MenteeService menteeService;


    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addMentee(@RequestBody Mentee mentee) {
        menteeService.addMentee(mentee);
    }

    @GetMapping("/getOne/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MenteeGetResponseDTO> getMentee(@PathVariable Integer id) {
        MenteeGetResponseDTO menteeGetResponseDTO = menteeService.getMentee(id);
        return ResponseEntity.ok(menteeGetResponseDTO);
    }

    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMentee(@PathVariable Integer id) {
        menteeService.deleteMentee(id);
    }
}
