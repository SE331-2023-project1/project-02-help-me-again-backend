package se331.helpme.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.helpme.project.controller.EventController;

import jakarta.annotation.PostConstruct;
import se331.helpme.project.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
    }

    @GetMapping("events")
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? eventList.size() : perPage;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * perPage;
        List<Event> output = new ArrayList<>();

        for (int i = firstIndex; i < firstIndex + perPage; i++) {
            output.add(eventList.get(i));
        }

        try {
            for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(eventList.get(i));
            }
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.ok(output);
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Event output = null;
        for (Event event : eventList) {
            if (event.getId().equals(id)) {
                output = event;
                break;
            }
        }
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }



}

