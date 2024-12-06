package pe.edu.i202224216.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	@Column(name = "store_id", nullable = false)
	private Integer storeId;

	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;
}
