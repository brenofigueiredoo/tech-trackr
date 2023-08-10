package com.breno.techtrackr.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breno.techtrackr.dto.TechnologiesDto;
import com.breno.techtrackr.model.Technologies;
import com.breno.techtrackr.service.TechnologiesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/techs")
public class TechnologiesController {

    private final TechnologiesService technologiesService;

    public TechnologiesController(TechnologiesService technologiesService) {
        this.technologiesService = technologiesService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Technologies> createTech(@Valid @RequestBody final TechnologiesDto techData,
            @PathVariable final String userId) {

        Technologies createdTech = technologiesService.createTechnologie(techData, Long.parseLong(userId));

        return new ResponseEntity<Technologies>(createdTech, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Technologies>> readTechnologies(@PathVariable final String userId) {
        final List<Technologies> allTechnologies = technologiesService.readTechnologies(Long.parseLong(userId));

        return new ResponseEntity<List<Technologies>>(allTechnologies,
                HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<User> retrieveUser(@PathVariable final String id) {
    // final User user = userService.retrieveUser(Long.parseLong(id));

    // return new ResponseEntity<User>(user, HttpStatus.OK);
    // }

    // @PatchMapping("/{id}")
    // public ResponseEntity<User> updateUser(@RequestBody final UserDto userData,
    // @PathVariable final String id) {
    // final User user = userService.updateUser(userData, Long.parseLong(id));

    // return new ResponseEntity<User>(user, HttpStatus.OK);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<User> deleteUser(@PathVariable final String id) {
    // userService.deleteUser(Long.parseLong(id));

    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
