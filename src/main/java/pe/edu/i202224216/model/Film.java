package pe.edu.i202224216.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "release_year")
	private Integer releaseYear;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	private Language language;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id" ,referencedColumnName = "language_id")
	private Language originalLanguage;

	@Column(name = "rental_duration")
	private Integer rentalDuration;

	@Column(name = "rental_rate" )
	private Double rentalRate;

	@Column(name = "length")
	private Integer length;

	@Column(name = "replacement_cost")
	private Double replacementCost;

	@Column(name = "rating")
	private String rating;

	@Column(name = "special_features")
	private String specialFeatures;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<FilmCategory> categories;

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Inventory> inventories;
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<FilmActor> actores;
}