package fr.m2i.tp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@NamedQuery(name = "Spectacle.findByCriteria", query = "SELECT s FROM Spectacle s INNER JOIN s.sessions s1 INNER JOIN s.category c WHERE s1.date = :date and c.id = :categoryId")
public class Spectacle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String title;
	private String description;
	private Integer duration;
	private Double price;
	private Integer nbPrices;

	@OneToMany(mappedBy = "spectacle", cascade = CascadeType.ALL)
	private List<Session> sessions;

	@ManyToOne(cascade = CascadeType.PERSIST)
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
