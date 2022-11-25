package br.com.fiap.smartcities.test;

import br.com.fiap.smartcities.domain.Category;
import br.com.fiap.smartcities.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class BancoTeste {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		try {
			entityManager.getTransaction().begin();

			userCRUDTest(entityManager);
			categoryCRUDTest(entityManager);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		System.exit(0);
	}

	private static void userCRUDTest(EntityManager entityManager) {
		User user = new User();
		user.setName("Ariel Ribeiro");
		entityManager.persist(user);

		User userFound = entityManager.find(User.class, 1);
		userFound.setName("Ariel Ribeiro Rodrigues da Cunha");

		entityManager.remove(userFound);
	}

	private static void categoryCRUDTest(EntityManager entityManager) {
		Category category = new Category();
		category.setName("Health");
		category.setKey("HEALTH");
		entityManager.persist(category);

		Category categoryFound = entityManager.find(Category.class, 1);
		categoryFound.setName("Education");
		categoryFound.setKey("EDUCATION");

		entityManager.remove(categoryFound);
	}

}
