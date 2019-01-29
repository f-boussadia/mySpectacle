package fr.m2i.tp.service;

import java.time.LocalDate;
import java.util.List;

import fr.m2i.tp.entity.Category;
import fr.m2i.tp.entity.Session;
import fr.m2i.tp.entity.Spectacle;

public interface ServiceSpectacle {
	public Category findCategoryById(Long id);

	public Category addCategory(Category category);

	public void removeCategory(Long id);

	public List<Category> allCategories();

	public List<Spectacle> findSpectacleByCategory(Long id);

	public List<Spectacle> findSpectacleByCriteria(LocalDate date, Long categoryId);

	public Spectacle findSpectacleById(Long id);

	public Spectacle addSpectacle(Spectacle spectacle, Long categoryId);

	public void updateSpectacle(Spectacle spectacle);

	public void removeSpectacle(Long spectacleId);

	public void addSession(Long spectacleId, Session session);

	public List<Session> findSessionsOfSpectacle(Long spectacleId);

	public Session findSessionById(Long id);

	public void removeSession(Long sessionId);

}
