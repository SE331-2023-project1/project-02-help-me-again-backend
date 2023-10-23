package se331.helpme.project.dao;

public interface AnnouncementDao {
    Integer getAnnouncementSize();
    Announcement save (Announcement announcement);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);
    Page<Announcement> getAnnouncements(Pageable page);
    Announcement getAnnouncement(Long id);
}

