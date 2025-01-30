package main.java.com.event.api.repository;

import main.java.com.event.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Vous pouvez ajouter des requêtes personnalisées ici, si nécessaire
}
