package pe.edu.i202224216.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "film_actor")
public class FilmActor {

	@Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @Column(name = "actor_id")
    private Integer actor;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
