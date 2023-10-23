package se331.helpme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.helpme.project.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
