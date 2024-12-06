package pe.edu.i202224216.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "film_id")
	private Film film;

	@Column(name = "store_id", nullable = false)
	private Integer storeId;

	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;
	
	// Relación con la entidad Rental
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rental> rentals;
}
