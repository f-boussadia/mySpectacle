package fr.m2i.tp.service;

import fr.m2i.tp.entity.Adress;
import fr.m2i.tp.entity.Person;

public interface PersonService {
	public Person addNewPerson(Person person);

	public Person findPersonById(Long id);

	public void specifyPersonAddress(Long personId, Adress adress);

	public void removePerson(Long personId);

	public void updatePerson(Person person);
}
