package pe.edu.i202224216.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
    private Inventory inventory;

   
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}