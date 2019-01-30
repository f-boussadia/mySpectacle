package fr.m2i.tp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateReservation;// date du jour
	private Double GlobalAmmount;// a calculer price de spectacle * nombre de personne

	@ManyToMany
	@JoinTable(name = "Resa_Personne", joinColumns = { @JoinColumn(name = "reservation_id") }, inverseJoinColumns = {
			@JoinColumn(name = "personne_id") })
	private List<Person> personnes;

	@ManyToOne
	private Customer customer;

	@OneToOne
	private Payement payement;

	@ManyToOne
	private Session session;

}
