package it.exolab.testmybatis.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(CategoriaFilm.class)
@Table(name = "categoria_film")
public class CategoriaFilm implements Serializable{

	private static final long serialVersionUID = -2104528267410435754L;
	
	@Id   
    @Column(name = "ID_FILM")
	private String idFilm;
	
	@Id
    @Column(name = "ID_CATEGORIA")
	private Integer idCategoria;
    
    @ManyToOne
	@JoinColumn(name="ID_FILM", nullable=false, insertable=false, updatable=false)
	private Film film;
    
    @ManyToOne
	@JoinColumn(name="ID_CATEGORIA", nullable=false, insertable=false, updatable=false)
    private Categoria categoria;
	
	public String getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(String idFilm) {
		this.idFilm = idFilm;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, idFilm);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaFilm other = (CategoriaFilm) obj;
		return idCategoria == other.idCategoria && Objects.equals(idFilm, other.idFilm);
	}
	
	@Override
	public String toString() {
		return "CategoriaFilm [idFilm=" + idFilm + ", idCategoria=" + idCategoria + "]";
	}
	
	
	

}
