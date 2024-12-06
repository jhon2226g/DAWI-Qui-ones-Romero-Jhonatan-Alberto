package pe.edu.i202224216.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Integer languageId;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "last_update", nullable = true)
	private LocalDateTime lastUpdate;
}
