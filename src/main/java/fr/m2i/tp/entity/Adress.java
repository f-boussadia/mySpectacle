package fr.m2i.tp.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Adress {

	private Long number;
	private String street;
	private String zip;
	private String town;
	private String country;

	public Adress(Long number, String street, String zip, String town, String country) {
		super();
		this.number = number;
		this.street = street;
		this.zip = zip;
		this.town = town;
		this.country = country;
	}

}
