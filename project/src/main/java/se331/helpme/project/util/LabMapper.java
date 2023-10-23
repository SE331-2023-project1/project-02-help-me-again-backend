package se331.helpme.project.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.servlet.ServletException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import se331.helpme.project.dao.AdvisorDao;
import se331.helpme.project.dto.AdvisorDTO;
import se331.helpme.project.dto.AnnouncementDTO;
import se331.helpme.project.dto.StudentDTO;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Announcement;
import se331.helpme.project.entity.Student;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    List<StudentDTO> getStudentDTO(List<Student> students);
    @Mapping(source = "ownStudent", target = "ownStudent")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.images", target = "images")
    @Mapping(source = "user.department", target = "department")
    @Mapping(source = "user.academic", target = "academic")
    AdvisorDTO getAdvisorDTO(Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);
    @Mapping(source = "advisor", target = "teacher")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.roles", target = "roles")
    @Mapping(source = "user.images", target = "images")
    @Mapping(source = "user.department", target = "department")

    StudentDTO getStudentDTO(Student student);
    AnnouncementDTO getAnnouncementDTO(Announcement announcement);
    @Mapping(source = "announcement", target = "announcement")
    @Mapping(source = "user.title", target = "title")
    @Mapping(source = "user.description", target = "description")
    @Mapping(source = "user.files", target = "files")
    List <AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcement);
}

