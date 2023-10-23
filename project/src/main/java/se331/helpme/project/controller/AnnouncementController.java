package se331.helpme.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.helpme.project.entity.Announcement;
import se331.helpme.project.service.AnnouncementService;
import se331.helpme.project.util.LabMapper;

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

