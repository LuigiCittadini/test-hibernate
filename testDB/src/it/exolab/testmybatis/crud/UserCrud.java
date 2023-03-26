package it.exolab.testmybatis.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exolab.testmybatis.constance.Constant;
import it.exolab.testmybatis.models.User;

public class UserCrud {

	public User insert(EntityManager entityManager, User user) {
		System.out.println("insert Crud user --> " + user);

		if (!entityManager.contains(user)) {
			System.out.println("entro nella condizione crud con " + user);
			user = entityManager.merge(user);
		}
		entityManager.persist(user);
		return user;
	}

	public User update(EntityManager entityManager, User user) {
		System.out.println("update Crud user --> " + user);

		entityManager.merge(user);
		return user;
	}

	public void delete(EntityManager entityManager, User user) {

		System.out.println("delete Crud idUser --> " + user);
		entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));

	}

	public User findById(EntityManager entityManager, String idUser) {
		System.out.println("findById Crud user --> " + idUser);
		User user = entityManager.find(User.class, idUser);
		System.out.println(idUser + " trovato");
		return user;
	}

	public List<User> findAll(EntityManager entityManager) {
		System.out.println("findAll Crud user");

		List<User> listaUser = new ArrayList<User>();
		Query query = entityManager.createNativeQuery("SELECT * FROM user", User.class);
		listaUser.addAll((List<User>) query.getResultList());
		return listaUser;
	}

	public User findByEmailPassword(EntityManager entityManager, User user) {

		System.out.println("findByEmailPassword Crud user --> " + user);
		Query query = entityManager
				.createQuery("SELECT p FROM User p WHERE p.email = :email And p.password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		return user = (User) query.getSingleResult();
	}

}
