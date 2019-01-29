package fr.m2i.tp.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.tp.dao.DaoPerson;
import fr.m2i.tp.entity.Adress;
import fr.m2i.tp.entity.Person;

@Service // hérite de @Coponent
@Transactional
public class PersonServiceImpl implements PersonService {

	private DaoPerson daoPerson; // dao vers lequel le service lui délègue

	// Méthode d'injection de dépendances
	@Autowired
	public void setDaoPerson(DaoPerson daoPerson) {
		this.daoPerson = daoPerson;
	}

	public PersonServiceImpl() {
		System.out.println("dans constructeur daoPerson = " + daoPerson);
	}

	@PostConstruct
	public void init() {
		System.out.println("dans la fonction init préfixé par PostConstruct daoPerson = " + daoPerson);
	}

	@Override
	public Person addNewPerson(Person person) {
		return daoPerson.save(person);
	}

	@Override
	public Person findPersonById(Long id) {
		return daoPerson.findById(id).orElse(null);
	}

	@Override
	public void specifyPersonAddress(Long personId, Adress adress) {
		Person person = daoPerson.findById(personId).orElse(null);
		person.setAdress(adress);
		daoPerson.save(person);

	}

	@Override
	public void removePerson(Long personId) {
		daoPerson.deleteById(personId);

	}

	@Override
	public void updatePerson(Person person) {
		daoPerson.save(person);

	}

}
