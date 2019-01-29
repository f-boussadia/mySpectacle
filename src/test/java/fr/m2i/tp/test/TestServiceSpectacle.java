package fr.m2i.tp.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.m2i.tp.MySpringBootApplication;
import fr.m2i.tp.entity.Category;
import fr.m2i.tp.entity.Session;
import fr.m2i.tp.entity.Spectacle;
import fr.m2i.tp.service.ServiceSpectacle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MySpringBootApplication.class })
@SpringBootTest(classes = { MySpringBootApplication.class })
public class TestServiceSpectacle {

	@Autowired
	private ServiceSpectacle serviceSpectacle;

	@Test
	public void test_addCategory() {

		Category category = new Category("Musical");
		this.serviceSpectacle.addCategory(category);

		Assert.assertTrue(category.getId() != null);

	}

	@Test
	public void test_removeCategory() {
		Category category = new Category("Musical1");
		this.serviceSpectacle.addCategory(category);

		this.serviceSpectacle.removeCategory(category.getId());

		Category c = this.serviceSpectacle.findCategoryById(category.getId());

		Assert.assertTrue(c == null);

	}

	@Test
	public void test_allCategories() {
		Category category = new Category("Musical2");
		this.serviceSpectacle.addCategory(category);

		Category category1 = new Category("Comedie");
		this.serviceSpectacle.addCategory(category1);

		Category category2 = new Category("Drame");
		this.serviceSpectacle.addCategory(category2);

		Category category3 = new Category("Animation");
		this.serviceSpectacle.addCategory(category3);

		List<Category> categories = this.serviceSpectacle.allCategories();

		Assert.assertTrue(4 <= categories.size());
	}

	@Test
	public void test_addSpectacle() {
		Category category = new Category("Musical3");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle", "il est génial", 120, 15.5, 150);

		this.serviceSpectacle.addSpectacle(spectacle, category.getId());

		Assert.assertTrue(spectacle.getId() != null);
		Assert.assertTrue(spectacle.getCategory().getId() == category.getId());
	}

	@Test
	public void test_findSpectacleByCategory() {
		Category category = new Category("Musical111");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle2", "il est génial", 120, 15.5, 150);
		Spectacle spectacle1 = new Spectacle("mon spectacle3", "il est génial", 120, 15.5, 150);
		Spectacle spectacle2 = new Spectacle("mon spectacle4", "il est génial", 120, 15.5, 150);

		this.serviceSpectacle.addSpectacle(spectacle, category.getId());
		this.serviceSpectacle.addSpectacle(spectacle1, category.getId());
		this.serviceSpectacle.addSpectacle(spectacle2, category.getId());

		List<Spectacle> spectacles = this.serviceSpectacle.findSpectacleByCategory(category.getId());

		Assert.assertEquals(3, spectacles.size(), 0.001);

	}

	@Test
	public void test_addSession() {
		Category category = new Category("Musical8");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle5", "il est génial", 120, 15.5, 150);
		this.serviceSpectacle.addSpectacle(spectacle, category.getId());

		Session session = new Session(LocalDate.of(2019, 4, 15), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session);

		Assert.assertTrue(session.getId() != null);

		Assert.assertTrue(session.getSpectacle().getId() == spectacle.getId());
	}

	@Test
	public void test_findSpectacleByCriteria() {
		Category category = new Category("Musical9");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle6", "il est génial", 120, 15.5, 150);
		this.serviceSpectacle.addSpectacle(spectacle, category.getId());

		Session session = new Session(LocalDate.of(2019, 4, 15), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session);

		List<Spectacle> spectacles = this.serviceSpectacle.findSpectacleByCriteria(LocalDate.of(2019, 4, 15),
				category.getId());

		Assert.assertTrue(spectacles.size() == 1);

	}

	@Test
	public void test_findSessionsOfSpectacle() {
		Category category = new Category("Musical10");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle7", "il est génial", 120, 15.5, 150);
		this.serviceSpectacle.addSpectacle(spectacle, category.getId());

		Session session = new Session(LocalDate.of(2019, 4, 15), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session);

		Session session1 = new Session(LocalDate.of(2019, 4, 16), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session1);

		Session session2 = new Session(LocalDate.of(2019, 4, 17), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session2);

		List<Session> sessions = this.serviceSpectacle.findSessionsOfSpectacle(spectacle.getId());

		Assert.assertTrue(sessions.size() == 3);
	}

	@Test
	public void test_removeSesssion() {
		Category category = new Category("Musical11");
		this.serviceSpectacle.addCategory(category);

		Spectacle spectacle = new Spectacle("mon spectacle9", "il est génial", 120, 15.5, 150);
		this.serviceSpectacle.addSpectacle(spectacle, category.getId());

		Session session = new Session(LocalDate.of(2019, 4, 15), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session);

		Session session1 = new Session(LocalDate.of(2019, 4, 16), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session1);

		Session session2 = new Session(LocalDate.of(2019, 4, 17), LocalTime.of(19, 0), 150);
		this.serviceSpectacle.addSession(spectacle.getId(), session2);

		List<Session> sessions = this.serviceSpectacle.findSessionsOfSpectacle(spectacle.getId());

		Assert.assertTrue(sessions.size() == 3);

		this.serviceSpectacle.removeSession(session2.getId());
		List<Session> sessions1 = this.serviceSpectacle.findSessionsOfSpectacle(spectacle.getId());

		Assert.assertTrue(sessions1.size() == 2);

	}

}
