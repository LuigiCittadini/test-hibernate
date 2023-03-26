package it.exolab.testmybatis.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 6508611290481436868L;
  
	@Id   
    @Column(name = "ID_USER")
	private String idUser;

    @Column(name = "NOME")
	private String nome;

    @Column(name = "COGNOME")
	private String cognome;

    @Column(name = "EMAIL")
	private String email;
  
    @Column(name = "PASSWORD")
	private String password;	
	   
    @Column(name = "ID_RUOLO")
	private int ruolo;
    
    
	
		
	public User() {
		this.ruolo = 1;
	}
	
	public User(String idUser) {
		this();		
		this.idUser = idUser;
	}
	
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public int getRuolo() {
		return ruolo;
	}
	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, email, nome, password, idUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(idUser, other.idUser);
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + "]";
	}
	
//	public String assegnaId(String idUser) {
//		System.out.println("User model --> assegno id");
//		Utility util = new Utility();
//		UserCrud userCrud = new UserCrud();
//		UserMapper mapperUser = SqlMapFactory.instance().getMapper(UserMapper.class);
//		while (userCrud.findById(mapperUser, idUser) != null) {
//			idUser = util.idGenerator();
//		}
//		return idUser;		
//	}
	
	

}
