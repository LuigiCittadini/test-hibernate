package it.exolab.testmybatis.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.exolab.testmybatis.crud.UserCrud;
import it.exolab.testmybatis.interfaces.UserInterface;
import it.exolab.testmybatis.models.User;
import it.exolab.testmybatis.utility.Utility;

@Stateless(name = "UserInterface")
@LocalBean
public class UserController extends EntityManagerHelper implements UserInterface {

	@PersistenceContext(name = "testModels")
	EntityManager entityManager = getEntityManager();

	public User insert(User user) {
		System.out.println("insert Controller user --> " + user);
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			user = userCrud.insert(entityManager, user);
			commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public User update(User user) {
		System.out.println("update Controller user" + user);
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			userCrud.update(entityManager, user);
			commit();
			user = findById(user.getIdUser());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public void delete(User user) {
		System.out.println("delete Controller username --> " + user);
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			userCrud.delete(entityManager, user);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			flush();
			closeEntityManager();
		}

	}

	public User findById(String idUser) {
		System.out.println("findById Controller usename --> " + idUser);
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			User user = userCrud.findById(entityManager, idUser);
			System.out.println(user + " trovato nel controller");
			commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<User> findAll() {
		System.out.println("findAll Controller user");
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			List<User> listaUser = userCrud.findAll(entityManager);
			commit();
			return listaUser;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public User findByEmailPassword(User user) {
		System.out.println("findByEmailPassword Controller user --> " + user);
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			user = userCrud.findByEmailPassword(entityManager, user);
			commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public String assegnaId(String idUser) {
		System.out.println("User model --> assegno id");
		Utility util = new Utility();
		UserCrud userCrud = new UserCrud();
		try {
			beginTransaction();
			while (userCrud.findById(entityManager, idUser) != null) {
				idUser = util.idGenerator();
			}
			commit();
			return idUser;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;

	}

}
