package it.exolab.testmybatis.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.exolab.testmybatis.crud.FilmCrud;
import it.exolab.testmybatis.crud.RegistaCrud;
import it.exolab.testmybatis.interfaces.FilmInterface;
import it.exolab.testmybatis.models.Film;
import it.exolab.testmybatis.models.Regista;
import it.exolab.testmybatis.utility.Utility;

@Stateless(name = "FilmInterface")
@LocalBean
public class FilmController extends EntityManagerHelper implements FilmInterface {
	@PersistenceContext(name = "testModels")
	EntityManager entityManager = getEntityManager();

	public Film insert(Film film, Regista regista) {
		System.out.println("insert Controller film --> " + film);

		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			if (registaCrud.findByNomeCognome(entityManager, regista) == null) {
				registaCrud.insert(entityManager, regista);
			} else {
				regista = registaCrud.findByNomeCognome(entityManager, regista);
				film.setIdRegista(regista.getIdRegista());
				FilmCrud filmCrud = new FilmCrud();
				filmCrud.insert(entityManager, film);
				commit();
			}
			return film;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public Film update(Film film) {
		System.out.println("insert Controller film --> " + film);
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			film = filmCrud.update(entityManager, film);
//			filmCrud.findById(film.getIdFilm());
			commit();
			return film;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public void delete(Film film) {
		System.out.println("delete Controller idFilm --> " + film);
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			filmCrud.delete(entityManager, film);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}

	}

	public Film findById(String idFilm) {
		System.out.println("findById Controller idFilm --> " + idFilm);
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			Film film = filmCrud.findById(entityManager, idFilm);
			commit();
			return film;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<Film> findAll() {
		System.out.println("findAll Controller film");
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			List<Film> listafilm = filmCrud.findAll(entityManager);
			commit();
			return listafilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<Film> findPerCategoria(int idcategoria) {
		System.out.println("find per categoria controller film");
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			List<Film> listafilm = filmCrud.findPerCategoria(entityManager, idcategoria);
			commit();
			return listafilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public String assegnaId(String idFilm) {
		System.out.println("Film model --> assegno id --> " + idFilm);
		Utility util = new Utility();
		FilmCrud filmCrud = new FilmCrud();
		try {
			beginTransaction();
			while (filmCrud.findById(entityManager, idFilm) != null) {
				idFilm = util.idGenerator();
			}
			commit();
			return idFilm;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

}
