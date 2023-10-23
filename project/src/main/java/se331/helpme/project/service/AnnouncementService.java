package se331.helpme.project.service;

import org.springframework.data.domain.Page;
import se331.helpme.project.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    Integer getAnnouncementSize();
    Announcement save (Announcement announcement);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);
    List<Announcement> getAnnouncements();
    Announcement getAnnouncement(Long id);
}
