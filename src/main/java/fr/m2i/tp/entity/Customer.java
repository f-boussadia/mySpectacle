package fr.m2i.tp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@DiscriminatorValue(value = "Customer")

public class Customer extends Person {

	private String password;

	private String username;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	public Customer(Long id, String firstName, String lastName, String email, String phoneNumber, LocalDate birthday,
			String password, String username) {
		super(id, firstName, lastName, email, phoneNumber, birthday);
		this.password = password;
		this.username = username;
	}

}
