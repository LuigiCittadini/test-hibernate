package it.exolab.testmybatis.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.exolab.testmybatis.crud.CategoriaFilmCrud;
import it.exolab.testmybatis.interfaces.CategoriaFilmInterface;
import it.exolab.testmybatis.models.CategoriaFilm;

@Stateless(name = "CategoriaFilmInterface")
@LocalBean
public class CategoriaFilmController extends EntityManagerHelper implements CategoriaFilmInterface {

	@PersistenceContext(name = "testModels")
	EntityManager entityManager = getEntityManager();

	public CategoriaFilm insert(CategoriaFilm categoriaFilm) {
		System.out.println("insert Controller categoriaFilm --> " + categoriaFilm);
		CategoriaFilmCrud categoriaFilmCrud = new CategoriaFilmCrud();
		try {
			beginTransaction();
			categoriaFilm = categoriaFilmCrud.insert(entityManager, categoriaFilm);
			commit();
			return categoriaFilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public CategoriaFilm update(CategoriaFilm categoriaFilm) {
		System.out.println("insert Controller categoriaFilm --> " + categoriaFilm);
		CategoriaFilmCrud categoriaFilmCrud = new CategoriaFilmCrud();
		try {
			beginTransaction();
			categoriaFilm = categoriaFilmCrud.update(entityManager, categoriaFilm);
//			categoriaFilmCrud.findById(categoriaFilm.getIdFilm());
			commit();
			return categoriaFilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public void delete(CategoriaFilm categoriaFilm) {
		System.out.println("delete Controller idFilm --> " + categoriaFilm);
		CategoriaFilmCrud categoriaFilmCrud = new CategoriaFilmCrud();
		try {
			beginTransaction();
			categoriaFilmCrud.delete(entityManager, categoriaFilm);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}

	}

	public CategoriaFilm findById(String idFilm) {
		System.out.println("findById Controller idFilm --> " + idFilm);
		CategoriaFilmCrud categoriaFilmilmCrud = new CategoriaFilmCrud();
		try {
			beginTransaction();
			CategoriaFilm categoriaFilm = categoriaFilmilmCrud.findById(entityManager, idFilm);
			commit();
			return categoriaFilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<CategoriaFilm> findAll() {
		System.out.println("findAll Controller categoria film");
		CategoriaFilmCrud categoriaFilmCrud = new CategoriaFilmCrud();
		try {
			beginTransaction();
			List<CategoriaFilm> listaCategorieFilm = categoriaFilmCrud.findAll(entityManager);
			commit();
			return listaCategorieFilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

}
