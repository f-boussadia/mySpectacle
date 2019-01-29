package fr.m2i.tp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Category;
import fr.m2i.tp.entity.Spectacle;

public interface DaoSpectacle extends CrudRepository<Spectacle, Long> {

	public List<Spectacle> findByCategory(Category category);

	public List<Spectacle> findByCriteria(LocalDate date, Long categoryId);

}
