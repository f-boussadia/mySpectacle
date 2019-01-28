package fr.m2i.tp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Spectacle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Integer duration;
	private Double price;
	private Integer nbPrices;

	@OneToMany(mappedBy = "spectacle")
	private List<Session> sessions;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CategoryId")
	private Category category;

	public Spectacle(String title, String description, Integer duration, Double price, Integer nbPrices) {
		super();
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.nbPrices = nbPrices;

	}

}
