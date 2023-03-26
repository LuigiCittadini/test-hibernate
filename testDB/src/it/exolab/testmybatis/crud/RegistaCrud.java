package it.exolab.testmybatis.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exolab.testmybatis.constance.Constant;
import it.exolab.testmybatis.models.Regista;

public class RegistaCrud{
	
	public Regista insert(EntityManager entityManager, Regista regista) {
		System.out.println("insert Crud regista --> " + regista);
		if (!entityManager.contains(regista)) {
			System.out.println("entro nella condizione crud con " + regista);
			regista = entityManager.merge(regista);
		}
		entityManager.persist(regista);
		return regista;

	}
	
	public Regista update(EntityManager entityManager, Regista regista) {
		System.out.println("update Crud regista --> " + regista);
			entityManager.merge(regista);
			return regista;
	}

	public void delete(EntityManager entityManager, Regista regista) {
		System.out.println("delete Crud regista --> " + regista);
			entityManager.remove(entityManager.contains(regista) ? regista : entityManager.merge(regista));
	}

	public Regista findById(EntityManager entityManager, String registaId) {
		System.out.println("findById Crud regista --> " + registaId);
			Regista regista = entityManager.find(Regista.class, registaId);
			return regista;
	}

	public List<Regista> findAll(EntityManager entityManager) {
		System.out.println("findAll Crud regista");
			List<Regista> listaRegisti = new ArrayList<Regista>();
			Query query = entityManager.createNativeQuery("SELECT * FROM regista", Regista.class);
			listaRegisti.addAll((List<Regista>) query.getResultList());			
			return listaRegisti;
	}

	public Regista findByNomeCognome(EntityManager entityManager, Regista regista) {

		System.out.println("findByNomeCognome Crud regista --> " + regista);
		Regista registaTrovato;
		try {
		    Query query = entityManager.createQuery("SELECT p FROM Regista p WHERE p.nome = :nome AND p.cognome = :cognome");
		    query.setParameter("nome", regista.getNome());
		    query.setParameter("cognome", regista.getCognome());
		    registaTrovato = (Regista) query.getSingleResult();
		    System.out.println("regista trovato " + registaTrovato);
		} catch (NoResultException e) {
		    System.out.println("Nessun regista trovato per i criteri di ricerca specificati.");
		    registaTrovato = null;
		}
		return registaTrovato;		
	}

}
