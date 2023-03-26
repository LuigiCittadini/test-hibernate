package it.exolab.testmybatis.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "regista")
public class Regista implements Serializable{
	
	private static final long serialVersionUID = -2585186409223491327L;

	@Id   
    @Column(name = "ID_REGISTA")
	private String idRegista;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "COGNOME")
	private String cognome;		
	
	
	public Regista() {
		
	}
	
	public Regista(String idRegista) {
		this.idRegista = idRegista;
	}	
	
	public String getIdRegista() {
		return idRegista;
	}
	public void setIdRegista(String idRegista) {
		this.idRegista = idRegista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
//	public String assegnaId(String idRegista) {
//		System.out.println("Regista model --> assegno id --> " + idRegista);
//		Utility util = new Utility();
//		RegistaCrud registaCrud = new RegistaCrud();
//		RegistaMapper mapperRegista = SqlMapFactory.instance().getMapper(RegistaMapper.class);
//		while (registaCrud.findById(mapperRegista, idRegista) != null) {
//			idRegista = util.idGenerator();
//		}
//		return idRegista;		
//	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cognome, idRegista, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regista other = (Regista) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(idRegista, other.idRegista)
				&& Objects.equals(nome, other.nome);
	}
	
	
	@Override
	public String toString() {
		return "Regista [idRegista=" + idRegista + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
	
	
	
	
	

}
