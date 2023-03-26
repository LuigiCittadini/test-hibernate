package it.exolab.testmybatis.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.exolab.testmybatis.models.Categoria;

public class CategoriaCrud {

	public Categoria insert(EntityManager entityManager, Categoria categoria) {
		System.out.println("insert Crud categoria --> " + categoria);
		if (!entityManager.contains(categoria)) {
			System.out.println("entro nella condizione crud con " + categoria);
			categoria = entityManager.merge(categoria);
		}
		entityManager.persist(categoria);
		return categoria;
	}

	public Categoria update(EntityManager entityManager, Categoria categoria) {
		System.out.println("update Crud categoria --> " + categoria);
		System.out.println("update Crud user --> " + categoria);
		entityManager.merge(categoria);
		return categoria;

	}

	public void delete(EntityManager entityManager, Categoria categoria) {
		System.out.println("delete Crud categoria id --> " + categoria);
		entityManager.remove(entityManager.contains(categoria) ? categoria : entityManager.merge(categoria));

	}

	public Categoria findById(EntityManager entityManager, int categoriaId) {
		System.out.println("findById Crud categoria id --> " + categoriaId);
		Categoria categoria = new Categoria();
		categoria = entityManager.find(Categoria.class, categoriaId);
		return categoria;

	}

	public List<Categoria> findAll(EntityManager entityManager) {
		System.out.println("findAll Crud categoria");
		List<Categoria> listaCategorie = new ArrayList<Categoria>();
		Query query = entityManager.createNativeQuery("SELECT * FROM categoria", Categoria.class);
		listaCategorie.addAll((List<Categoria>) query.getResultList());
		return listaCategorie;

	}

}
