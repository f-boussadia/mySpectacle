package fr.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Person;

public interface DaoPerson extends CrudRepository<Person, Long> {

}
