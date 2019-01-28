package fr.m2i.tp.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

	public Customer(Long id, String firstName, String lastName, String email, String phoneNumber, Date birthday,
			Adress adress, String password, String username) {
		super(id, firstName, lastName, email, phoneNumber, birthday, adress);
		this.password = password;
		this.username = username;
	}

}
