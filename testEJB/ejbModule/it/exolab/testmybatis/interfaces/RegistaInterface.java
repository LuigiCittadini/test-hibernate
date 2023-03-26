package it.exolab.testmybatis.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.testmybatis.models.Regista;

@Local
public interface RegistaInterface {
	
	public Regista insert(Regista regista);
	
	public Regista update(Regista regista);
	
	public void delete(Regista regista);
	
	public Regista findById(String idRegista);
	
	public List<Regista> findAll();
	
	public Regista findByNomeCognome(Regista regista);
	
	public String assegnaId(String idRegista);

}
