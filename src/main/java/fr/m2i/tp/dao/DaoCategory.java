package fr.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Category;

public interface DaoCategory extends CrudRepository<Category, Long> {

}
