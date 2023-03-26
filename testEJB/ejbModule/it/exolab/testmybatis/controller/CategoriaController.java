package it.exolab.testmybatis.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.exolab.testmybatis.crud.CategoriaCrud;
import it.exolab.testmybatis.interfaces.CategoriaInterface;
import it.exolab.testmybatis.models.Categoria;

@Stateless(name = "CategoriaInterface")
@LocalBean
public class CategoriaController extends EntityManagerHelper implements CategoriaInterface {
	@PersistenceContext(name = "testModels")
	EntityManager entityManager = getEntityManager();

	public Categoria insert(Categoria categoria) {
		System.out.println("insert Controller categoria --> " + categoria);
		CategoriaCrud categoriaCrud = new CategoriaCrud();
		try {
			beginTransaction();
			categoria = categoriaCrud.insert(entityManager, categoria);
			commit();
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public Categoria update(Categoria categoria) {
		System.out.println("update Controller categoria" + categoria);
		CategoriaCrud categoriaCrud = new CategoriaCrud();
		try {
			beginTransaction();
			categoriaCrud.update(entityManager, categoria);
//			categoria = findById(categoria.getIdCategoria());
			commit();
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public void delete(Categoria categoria) {
		System.out.println("delete Controller id categoria --> " + categoria);
		CategoriaCrud categoriaCrud = new CategoriaCrud();
		try {
			beginTransaction();
			categoriaCrud.delete(entityManager, categoria);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}

	}

	public Categoria findById(int idCategoria) {
		System.out.println("findById Controller id categoria --> " + idCategoria);
		CategoriaCrud categoriaCrud = new CategoriaCrud();
		try {
			beginTransaction();
			Categoria categoria = categoriaCrud.findById(entityManager, idCategoria);
			commit();
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<Categoria> findAll() {
		System.out.println("findAll Controller categoria");
		CategoriaCrud categoriaCrud = new CategoriaCrud();
		try {
			beginTransaction();
			List<Categoria> listaCategorie = categoriaCrud.findAll(entityManager);
			commit();
			return listaCategorie;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

}
