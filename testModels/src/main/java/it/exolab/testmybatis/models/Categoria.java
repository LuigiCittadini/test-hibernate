package it.exolab.testmybatis.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.exolab.testmybatis.enums.Genere;


@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{	

	private static final long serialVersionUID = -4080953911013799365L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
	private Integer idCategoria;
	
	@Column(name = "GENERE")
	private String genere;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIA", nullable=false, insertable=false, updatable=false)
//	@JsonbTransient
    private Film film;
	
	@ManyToMany(mappedBy = "listaGeneriDelFilm")
//  @JsonbTransient
	private List<Film> listaFilm;



	public List<Film> getListaFilm() {
		return listaFilm;
	}


	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	@Override
	public int hashCode() {
		return Objects.hash(genere, idCategoria);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return genere == other.genere && idCategoria == other.idCategoria;
	}


	@Override
	public String toString() {
		return genere + "";
	}
	
	
	
	
	
	
	
	
	

}
