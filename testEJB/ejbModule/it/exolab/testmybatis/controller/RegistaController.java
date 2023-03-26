package it.exolab.testmybatis.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.exolab.testmybatis.crud.RegistaCrud;
import it.exolab.testmybatis.interfaces.RegistaInterface;
import it.exolab.testmybatis.models.Regista;
import it.exolab.testmybatis.utility.Utility;

@Stateless(name = "RegistaInterface") // questo nome serve alla lookUp per ritrovre l'EJB
@LocalBean
public class RegistaController extends EntityManagerHelper implements RegistaInterface {
	@PersistenceContext(name = "testModels")
	EntityManager entityManager = getEntityManager();

	public Regista insert(Regista regista) {

		System.out.println("insert Controller regista --> " + regista);
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			regista = registaCrud.insert(entityManager, regista);
			commit();
			return regista;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;

	}

	public Regista update(Regista regista) {

		System.out.println("update Controller regista" + regista);
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			registaCrud.update(entityManager, regista);
			commit();
//			regista = findById(regista.getIdRegista());
			return regista;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public void delete(Regista regista) {
		System.out.println("delete Controller idRegista --> " + regista);
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			registaCrud.delete(entityManager, regista);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}

	}

	public Regista findById(String idRegista) {
		System.out.println("findById Controller idRegista --> " + idRegista);
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			Regista regista = registaCrud.findById(entityManager, idRegista);
			commit();
			return regista;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public List<Regista> findAll() {
		System.out.println("findAll Controller regista");
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			List<Regista> listaRegisti = registaCrud.findAll(entityManager);
			commit();
			return listaRegisti;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public Regista findByNomeCognome(Regista regista) {
		System.out.println("findByNomeCognome Controller user --> " + regista);
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			regista = registaCrud.findByNomeCognome(entityManager, regista);
			commit();
			return regista;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	public String assegnaId(String idRegista) {
		System.out.println("Regista model --> assegno id --> " + idRegista);
		Utility util = new Utility();
		RegistaCrud registaCrud = new RegistaCrud();
		try {
			beginTransaction();
			while (registaCrud.findById(entityManager, idRegista) != null) {
				idRegista = util.idGenerator();
			}
			commit();
			return idRegista;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}
}
