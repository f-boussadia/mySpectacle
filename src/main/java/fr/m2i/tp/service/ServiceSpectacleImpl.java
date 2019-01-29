package fr.m2i.tp.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.tp.dao.DaoCategory;
import fr.m2i.tp.dao.DaoSession;
import fr.m2i.tp.dao.DaoSpectacle;
import fr.m2i.tp.entity.Category;
import fr.m2i.tp.entity.Session;
import fr.m2i.tp.entity.Spectacle;
import lombok.NoArgsConstructor;

@Service
@Transactional
@NoArgsConstructor
public class ServiceSpectacleImpl implements ServiceSpectacle {

	@Autowired
	private DaoSpectacle daoSpectacle;

	@Autowired
	private DaoSession daoSession;

	@Autowired
	private DaoCategory daoCategory;

	@Override
	public Category findCategoryById(Long id) {

		return daoCategory.findById(id).orElse(null);
	}

	@Override
	public Category addCategory(Category category) {
		daoCategory.save(category);
		return category;
	}

	@Override
	public void removeCategory(Long id) {
		daoCategory.deleteById(id);
	}

	@Override
	public List<Category> allCategories() {

		return (List<Category>) daoCategory.findAll();
	}

	@Override
	public List<Spectacle> findSpectacleByCategory(Long id) {

		return daoSpectacle.findByCategory(this.findCategoryById(id));
	}

	@Override
	public List<Spectacle> findSpectacleByCriteria(LocalDate date, Long categoryId) {

		return daoSpectacle.findByCriteria(date, categoryId);
	}

	@Override
	public Spectacle findSpectacleById(Long id) {

		return daoSpectacle.findById(id).orElse(null);
	}

	@Override
	public Spectacle addSpectacle(Spectacle spectacle, Long categoryId) {

		spectacle.setCategory(this.findCategoryById(categoryId));
		daoSpectacle.save(spectacle);
		return null;
	}

	@Override
	public void updateSpectacle(Spectacle spectacle) {
		daoSpectacle.save(spectacle);
	}

	@Override
	public void removeSpectacle(Long spectacleId) {
		daoSpectacle.deleteById(spectacleId);
	}

	@Override
	public void addSession(Long spectacleId, Session session) {
		session.setSpectacle(this.findSpectacleById(spectacleId));
		daoSession.save(session);
	}

	@Override
	public List<Session> findSessionsOfSpectacle(Long spectacleId) {
		return daoSession.findBySpectacleId(spectacleId);
	}

	@Override
	public Session findSessionById(Long id) {
		return daoSession.findById(id).orElse(null);
	}

	@Override
	public void removeSession(Long sessionId) {
		daoSession.deleteById(sessionId);
	}

}
