package com.example.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="cars")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	 private int id;

	@Column(name="plate", unique = true )
	private String plate;

	@Column(name="dailyPrice")
	private double dailyPrice;

	@Column(name="modelYear")
	private int modelYear;

	@Column(name="state")
	private int state;

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
}
