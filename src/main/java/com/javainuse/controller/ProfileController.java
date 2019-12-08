package com.javainuse.controller;

import com.javainuse.model.DAOUser;
import com.javainuse.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

     @GetMapping("/profile/{profileId}")
    public ResponseEntity<?> getUserProfile(@PathVariable("profileId") Long id) {
        return ResponseEntity.ok().body(profileService.findUserById(id));
    }

    @PutMapping("/update-profile")
    public ResponseEntity<?> updateUserProfile(@RequestBody DAOUser profile) {
         return ResponseEntity.ok().body(profileService.updateProfile(profile));
    }
}
