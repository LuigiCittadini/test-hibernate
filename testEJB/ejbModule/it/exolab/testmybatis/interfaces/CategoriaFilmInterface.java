package it.exolab.testmybatis.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.testmybatis.models.CategoriaFilm;

@Local
public interface CategoriaFilmInterface {
	
	public CategoriaFilm insert(CategoriaFilm categoriaFilm);
	
	public CategoriaFilm update(CategoriaFilm categoriaFilm);
	
	public void delete(CategoriaFilm categoriafilm);
	
	public CategoriaFilm findById(String idFilm);
	
	public List<CategoriaFilm> findAll();

}
