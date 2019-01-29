package fr.m2i.tp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private LocalTime startTime;
	private Integer nbRemainingPlaces;

	@ManyToOne
	@JoinColumn(name = "SpectacleId")
	private Spectacle spectacle;

	public Session(LocalDate date, LocalTime startTime, Integer nbRemainingPlaces) {
		this.date = date;
		this.startTime = startTime;
		this.nbRemainingPlaces = nbRemainingPlaces;
	}

}
