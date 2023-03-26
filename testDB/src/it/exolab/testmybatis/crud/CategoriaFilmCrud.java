package it.exolab.testmybatis.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.exolab.testmybatis.models.CategoriaFilm;

public class CategoriaFilmCrud{
	
	
	public CategoriaFilm insert(EntityManager entityManager, CategoriaFilm categoriaFilm) {
		System.out.println("insert Crud categoria film --> " + categoriaFilm);
			if (!entityManager.contains(categoriaFilm)) {
				System.out.println("entro nella condizione crud con " + categoriaFilm);
				categoriaFilm = entityManager.merge(categoriaFilm);
			}
			entityManager.persist(categoriaFilm);
			return categoriaFilm;
	}
	
	public CategoriaFilm update(EntityManager entityManager, CategoriaFilm categoriaFilm) {
		System.out.println("insert Crud categoria film --> " + categoriaFilm );
			entityManager.merge(categoriaFilm);
			return categoriaFilm;
			
	}


	public void delete(EntityManager entityManager, CategoriaFilm categoriaFilm) {
		System.out.println("delete Crud filmId --> " + categoriaFilm);
			entityManager.remove(entityManager.contains(categoriaFilm) ? categoriaFilm : entityManager.merge(categoriaFilm));
		
	}

	public CategoriaFilm findById(EntityManager entityManager, String filmId) {
		System.out.println("findById Crud categoria film --> " + filmId);
			CategoriaFilm categoriaFilm = new CategoriaFilm();
			categoriaFilm = entityManager.find(CategoriaFilm.class, filmId);
			return categoriaFilm;
	}


	public List<CategoriaFilm> findAll(EntityManager entityManager) {
		System.out.println("findAll Crud categoria film");
			List<CategoriaFilm> listaCategorieFilm = new ArrayList<CategoriaFilm>();
			Query query = entityManager.createNativeQuery("SELECT * FROM categoria_film", CategoriaFilm.class);
			listaCategorieFilm.addAll((List<CategoriaFilm>) query.getResultList());
			return listaCategorieFilm;
	}

}
