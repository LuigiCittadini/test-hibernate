package it.exolab.testmybatis.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.exolab.testmybatis.models.Film;

public class FilmCrud {

	public Film insert(EntityManager entityManager, Film film) {
		System.out.println("insert Crud film --> " + film);
		if (!entityManager.contains(film)) {
			System.out.println("entro nella condizione crud con " + film);
			film = entityManager.merge(film);
		}
		entityManager.persist(film);
		System.out.println("film inserito correttamente");
		return film;
	}

	public Film update(EntityManager entityManager, Film film) {
		System.out.println("update Crud film --> " + film);
		entityManager.merge(film);
		return film;
	}

	public void delete(EntityManager entityManager, Film film) {
		System.out.println("delete Crud film --> " + film);
		entityManager.remove(entityManager.merge(film));
	}

	public Film findById(EntityManager entityManager, String filmId) {
		System.out.println("findById Crud film --> " + filmId);
		System.out.println("findById Crud film --> apre connessione");
		Film film = new Film();
		film = entityManager.find(Film.class, filmId);
		return film;
	}

	public Film findByTitolo(EntityManager entityManager, String titoloFilm) {
		System.out.println("findByTitolo Crud film --> " + titoloFilm);
		Film film = new Film();
		film = entityManager.find(Film.class, titoloFilm);
		return film;
	}

	public List<Film> findAll(EntityManager entityManager) {
		System.out.println("findAll Crud film");
		List<Film> listaFilm = new ArrayList<Film>();
		Query query = entityManager.createNativeQuery("SELECT * FROM film", Film.class);
		listaFilm.addAll((List<Film>) query.getResultList());
		return listaFilm;
	}

	public List<Film> findPerCategoria(EntityManager entityManager, int idCategoria) {
		System.out.println("find per categoria Crud film");
		List<Film> listaFilm = new ArrayList<>();
		Query query = entityManager.createNativeQuery("SELECT * " + "FROM film f "
				+ "JOIN categoria_film cf ON f.id_film = cf.id_film "
				+ "JOIN categoria c ON cf.id_categoria = c.id_categoria " + "WHERE c.id_categoria = " + idCategoria,
				Film.class);
		listaFilm.addAll((List<Film>) query.getResultList());
		return listaFilm;
	}

}
