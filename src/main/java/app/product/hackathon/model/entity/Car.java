package app.product.hackathon.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String brand;
	private Double price;
	private CarStatus status;
	@Column(name = "is_deleted")
	private Boolean isDeleted;
}
