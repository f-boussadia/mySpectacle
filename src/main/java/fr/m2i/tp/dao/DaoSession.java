package fr.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tp.entity.Session;

public interface DaoSession extends CrudRepository<Session, Long> {

	public List<Session> findBySpectacleId(Long id);

}
