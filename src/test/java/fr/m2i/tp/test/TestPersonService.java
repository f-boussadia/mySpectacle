package fr.m2i.tp.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.m2i.tp.MySpringBootApplication;
import fr.m2i.tp.entity.Adress;
import fr.m2i.tp.entity.Person;
import fr.m2i.tp.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MySpringBootApplication.class })
public class TestPersonService {
	@Autowired
	private PersonService personService;

	@Test
	public void test1_AddNewPerson() {
		Person person = new Person(null, "Ines", "Khlif", "ineskhlif@ya.com", "01256897", LocalDate.of(1982, 8, 20));
		this.personService.addNewPerson(person);
		Assert.assertTrue(person.getId() != null);
		System.out.println("Person = " + person.toString());
	}

	@Test
	public void test2_FindPersonById() {
		Person person = new Person(null, "Fairouz", "Boussadia", "FaiBou@ya.com", "05876245",
				LocalDate.of(1985, 6, 15));
		this.personService.addNewPerson(person);
		Person personNew = this.personService.findPersonById(1L);
		Assert.assertTrue(personNew != null);
	}

	@Test
	public void test3_SpecifyPersonAddress() {
		Person personNew1 = new Person(null, "Ines", "Khlif", "ineskhlif@ya.com", "01256897",
				LocalDate.of(1982, 8, 20));
		this.personService.addNewPerson(personNew1);
		Person personNew2 = new Person(null, "Fairouz", "Boussadia", "FaiBou@ya.com", "05876245",
				LocalDate.of(1985, 6, 15));
		this.personService.addNewPerson(personNew2);
		this.personService.specifyPersonAddress(1L, new Adress(20L, "chateau", "92500", "RueilMalmaison", "France"));
		Person personAModifie = this.personService.findPersonById(1L);
		Assert.assertTrue(personAModifie.getAdress() != null);
	}

	// La suppression à tester coté Dao. Test fait en vérifiant la suppression de la
	// ligne coté base
//	@Test  
//	public void test4_RemovePerson() {
//		Person personNew1 = new Person(null, "Rim", "Khlif", "rimkhlif@ya.com", "05847532", LocalDate.of(1985, 8, 20));
//		this.personService.addNewPerson(personNew1);
//		Person personNew2 = new Person(null, "Ines", "Khlif", "ineskhlif@ya.com", "01256897",
//				LocalDate.of(1982, 8, 20));
//		this.personService.addNewPerson(personNew2);
//		Person personNew3 = new Person(null, "Fairouz", "Boussadia", "FaiBou@ya.com", "05876245",
//				LocalDate.of(1985, 6, 15));
//		this.personService.addNewPerson(personNew3);
//		this.personService.specifyPersonAddress(1L, new Adress(20L, "chateau", "92500", "RueilMalmaison", "France"));
//		this.personService.removePerson(2L);
//
//		Assert.assertTrue(personService.findPersonById(2L).equals(null));
//	}

}