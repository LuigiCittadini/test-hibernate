package it.exolab.testmybatis.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.testmybatis.models.Categoria;

@Local
public interface CategoriaInterface {
	
	public Categoria insert(Categoria categoria);
	
	public Categoria update(Categoria categoria);
	
	public void delete(Categoria categoria);
	
	public Categoria findById(int idCategoria);
	
	public List<Categoria> findAll();

}
