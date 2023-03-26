package it.exolab.testmybatis.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.testmybatis.models.Film;
import it.exolab.testmybatis.models.Regista;

@Local
public interface FilmInterface {
	
	public Film insert(Film film, Regista regista);
	
	public Film update(Film film);
	
	public void delete(Film film);
	
	public Film findById(String idFilm);
	
	public List<Film> findAll();
	
	public List<Film> findPerCategoria(int idCategoria); 
	
	public String assegnaId(String idFilm);

}
