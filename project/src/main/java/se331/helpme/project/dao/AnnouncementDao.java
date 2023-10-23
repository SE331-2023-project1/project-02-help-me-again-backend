package se331.helpme.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Announcement;

public interface AnnouncementDao {
    Integer getAnnouncementSize();
    Announcement save (Announcement announcement);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);
    Page<Announcement> getAnnouncements(Pageable page);
    Announcement getAnnouncement(Long id);
}

