package main.java.com.event.api.service;

import main.java.com.event.api.model.Event;
import main.java.com.event.api.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setName(updatedEvent.getName());
                    event.setDescription(updatedEvent.getDescription());
                    event.setLocation(updatedEvent.getLocation());
                    event.setStartDateTime(updatedEvent.getStartDateTime());
                    event.setEndDateTime(updatedEvent.getEndDateTime());
                    event.setPrice(updatedEvent.getPrice());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id " + id));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
