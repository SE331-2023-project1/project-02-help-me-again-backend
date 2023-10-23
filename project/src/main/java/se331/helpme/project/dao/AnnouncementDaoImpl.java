package se331.helpme.project.dao;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;
    @Override
    public Integer getAnnouncementSize() {
        return Math.toIntExact(announcementRepository.count());
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncements(Integer pageSize, Integer page) {
        return announcementRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Announcement> getAnnouncements(Pageable page) {
        return announcementRepository.findAll(page);
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

}