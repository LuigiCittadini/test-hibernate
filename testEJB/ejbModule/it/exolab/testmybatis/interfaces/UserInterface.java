package it.exolab.testmybatis.interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.testmybatis.models.User;

@Local
public interface UserInterface {
	
	public User insert(User user);
	
	public User update(User user);
	
	public void delete(User user);
	
	public User findById(String idUser);
	
	public List<User> findAll();
	
	public User findByEmailPassword(User user);
	
	public String assegnaId(String idUser);

}
