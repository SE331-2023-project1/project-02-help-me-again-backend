package se331.helpme.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnnouncementController {
    final AnnouncementService announcementService;

    @GetMapping("announcement")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAnnouncements() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(announcementService.getAnnouncements()));
    }
    @PostMapping("announcement")
    public ResponseEntity<?> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement output = announcementService.save(announcement);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output));
    }
}

