package it.exolab.testmybatis.models;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film implements Serializable{

	private static final long serialVersionUID = -2028786159443940517L;
	
	@Id   
    @Column(name = "ID_FILM")
	private String idFilm;
	
	@Column(name = "TITOLO")
	private String titolo;
	
	@Column(name = "ID_REGISTA")
	private String idRegista;
	
	@Column(name = "ANNO")
	private Date anno;
	
	@Column(name = "CLASSIFICAZIONE")
	private String classificazione;
	
	@Column(name = "NAZIONALITA")
	private String nazionalita;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade ={CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name="categoria_film",    
        joinColumns= 
            @JoinColumn(name="ID_FILM", referencedColumnName="ID_FILM"),
        inverseJoinColumns=
            @JoinColumn(name="ID_CATEGORIA", referencedColumnName="ID_CATEGORIA")
        )
	private List<Categoria> listaGeneriDelFilm;

	
	@ManyToOne
	@JoinColumn(name="ID_REGISTA", nullable=false, insertable=false, updatable=false)
	private Regista regista;
	
	public Film() {
		
	}
	public Film(String idFilm) {
		this.idFilm = idFilm;
	}

	public String getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(String idFilm) {
		this.idFilm = idFilm;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getIdRegista() {
		return idRegista;
	}
	public void setIdRegista(String idRegista) {
		this.idRegista = idRegista;
	}
	public Date getAnno() {
		return anno;
	}
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	public String getClassificazione() {
		return classificazione;
	}
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}		
	public List<Categoria> getListaGeneriDelFilm() {
		return listaGeneriDelFilm;
	}
	public void setListaGeneriDelFilm(List<Categoria> listaGeneriDelFilm) {
		this.listaGeneriDelFilm = listaGeneriDelFilm;
	}
	public Regista getRegista() {
		return regista;
	}
	public void setRegista(Regista regista) {
		this.regista = regista;
	}
	
	
//	
//	public String assegnaId(String idFilm) {
//		System.out.println("Film model --> assegno id --> " + idFilm);
//		Utility util = new Utility();
//		FilmCrud filmCrud = new FilmCrud();
//		FilmMapper mapperFilm =  SqlMapFactory.instance().getMapper(FilmMapper.class);
//		while (filmCrud.findById(mapperFilm, idFilm) != null) {
//			idFilm = util.idGenerator();
//		}
//		return idFilm;		
//	}


	


	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", titolo=" + titolo + ", idRegista=" + idRegista + ", anno=" + anno
				+ ", classificazione=" + classificazione + ", nazionalita=" + nazionalita + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(anno, classificazione, idFilm, idRegista, listaGeneriDelFilm, nazionalita, regista, titolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(anno, other.anno) && Objects.equals(classificazione, other.classificazione)
				&& Objects.equals(idFilm, other.idFilm) && Objects.equals(idRegista, other.idRegista)
				&& Objects.equals(listaGeneriDelFilm, other.listaGeneriDelFilm)
				&& Objects.equals(nazionalita, other.nazionalita) && Objects.equals(regista, other.regista)
				&& Objects.equals(titolo, other.titolo);
	}
	
	
	
	
	
	

}
