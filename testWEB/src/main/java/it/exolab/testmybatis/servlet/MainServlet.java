package it.exolab.testmybatis.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.testmybatis.interfaces.FilmInterface;
import it.exolab.testmybatis.interfaces.RegistaInterface;
import it.exolab.testmybatis.interfaces.UserInterface;
import it.exolab.testmybatis.models.Categoria;
import it.exolab.testmybatis.models.Film;
import it.exolab.testmybatis.models.Regista;
import it.exolab.testmybatis.models.User;
import it.exolab.testmybatis.utility.Utility;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	UserInterface userInterface;
	@EJB
	FilmInterface filmInterface;
	@EJB
	RegistaInterface registaInterface;
	
	
    public MainServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nella servlet - GET");
		
		try {
			if(null != request.getParameter("toGetAll")) {
				toGetAll(request);
				request.getRequestDispatcher("recap.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetAllFilm")) {
				toGetAllFilm(request);
				request.getRequestDispatcher("findAllFilm.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetAvventura")) {
				toGetAvventura(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetRomantico")) {
				toGetRomantico(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetDrammatico")) {
				toGetDrammatico(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetThriller")) {
				toGetThriller(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetHorror")) {
				toGetHorror(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetFantasy")) {
				toGetFantasy(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toGetDocumentario")) {
				toGetDocumentario(request);
				request.getRequestDispatcher("listaFilmPerCategoria.jsp").include(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nella servlet - POST");

		try {
			if (null != request.getParameter("toLogin")) {
				if (toLogin(request)) {
					if( accessoAreaUtenteOAmministratore(request).getRuolo() == 1 ) { // <--- 1 indica il ruolo di utente 
						System.out.println("Nell area utente");
						request.getRequestDispatcher("recap.jsp").include(request, response);
					}
					else if( accessoAreaUtenteOAmministratore(request).getRuolo() == 2) { // <--- 2 indica il ruolo di amministratore
						System.out.println("Nell area amministratore");
						request.getRequestDispatcher("admin.jsp").include(request, response);
					}
				} else {
					request.getRequestDispatcher("login.jsp").include(request, response);
				}
			}
			if (null != request.getParameter("toInsert")) {
				toInsert(request);
				request.getRequestDispatcher("recap.jsp").include(request, response);
			} 
			
			if (null != request.getParameter("toRendiAmministratore")) {
				rendiAministratore(request);
				request.getRequestDispatcher("manageAdmin.jsp").include(request, response);
			}
			
			if (null != request.getParameter("toInsertRegista")) {
				toInsertRegista(request);
				request.getRequestDispatcher("recap.jsp").include(request, response);
			} 			
			
			else if(null != request.getParameter("toUpdate")) {
				toUpdate(request);
				request.getRequestDispatcher("recap.jsp").include(request, response);	
			} 
			else if(null != request.getParameter("toDelete")) {
				toDelete(request);
				request.getRequestDispatcher("logout.jsp").include(request, response);	
			}
			else if(null != request.getParameter("insertFilm")) {
				insertFilm(request);
				request.getRequestDispatcher("manageAdmin.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toDeleteFilm")) {
				toDeleteFilm(request);
				request.getRequestDispatcher("deleteFilm.jsp").include(request, response);	
			}
			else if(null != request.getParameter("toUpdateFilm")) {
				toUpdateFilm(request);
				request.getRequestDispatcher("manageAdmin.jsp").include(request, response);	
			} 
			else if(null != request.getParameter("toInfoFilm")) {
				toInfoFilm(request);
				request.getRequestDispatcher("infoFilm.jsp").include(request, response);	
			}
			 
			else if(null != request.getParameter("salvaFilmPerUpdate")) {
				salvaFilmPerUpdate(request);
				request.getRequestDispatcher("updateFilm.jsp").include(request, response);	
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
	}

	private void toInsert(HttpServletRequest request) {

		System.out.println("Nell toInsert");

		
		//genera id
		Utility util = new Utility();
		String idUser = util.idGenerator();
		User user = new User(userInterface.assegnaId(idUser));
		System.out.println("is user --> " + user.getIdUser());
		user.setNome(request.getParameter("nome"));
		user.setCognome(request.getParameter("cognome"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user = userInterface.insert(user);
		request.getSession().setAttribute("user", user);

	}
	
	private void toInsertRegista(HttpServletRequest request) {

		System.out.println("Nell toInsert");

		
		//genera id
		Utility util = new Utility();
		String idRegista = util.idGenerator();
		Regista regista = new Regista(registaInterface.assegnaId(idRegista));
		System.out.println("is user --> " + regista.getIdRegista());
		regista.setNome(request.getParameter("nome"));
		regista.setCognome(request.getParameter("cognome"));
		regista = registaInterface.insert(regista);
		request.getSession().setAttribute("regista", regista);

	}

	private boolean toLogin(HttpServletRequest request) {

		System.out.println("Nell toLogin");
		User user = new User();
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));		

		user = userInterface.findByEmailPassword(user);		
		if (user == null) {
			return false;

		}
		else {
			request.getSession().setAttribute("user", user);
			return true;
		}
	}
	
	public User accessoAreaUtenteOAmministratore(HttpServletRequest request) {
		System.out.println("Nell accesso area utente o amministratore ");
		
		User user = new User();
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));	
		user = userInterface.findByEmailPassword(user);
		return user;
	}

	private void toUpdate(HttpServletRequest request) {

		System.out.println("Nell toUpdate");

		User user = new User();

		user.setIdUser(request.getParameter("idUser"));
		user.setNome(request.getParameter("nome"));
		user.setCognome(request.getParameter("cognome"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		user = userInterface.update(user);
		request.getSession().setAttribute("user", user);
	}

	private void toGetAll(HttpServletRequest request) {
		System.out.println("Nell toGetAll");

		

		List<User> listaUser = userInterface.findAll();
		request.getSession().setAttribute("listaUser", listaUser);
	}
	private void toGetAllFilm(HttpServletRequest request) {
		System.out.println("Nell toGetAllFilm");

		List<Film> listaFilm = filmInterface.findAll();
		request.getSession().setAttribute("listaFilm", listaFilm);
	}

	private void toDelete(HttpServletRequest request) {
		System.out.println("Nell toDelete");
		String idUser = request.getParameter("idUser");
		User user = userInterface.findById(idUser);
		System.out.println("elimino ---> " + user);
		userInterface.delete(user);
		// svuoto il passeggero in sessione
		request.getSession().setAttribute("user", new User());
	}
	
	
	
	
	private void toGetAvventura(HttpServletRequest request) {
		System.out.println("Nell toGetAvventuraAllFilm");	
		List<Film> listaFilm = filmInterface.findPerCategoria(1);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetRomantico(HttpServletRequest request) {
		System.out.println("Nell toGetRomantico");
		List<Film> listaFilm = filmInterface.findPerCategoria(2);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetDrammatico(HttpServletRequest request) {
		System.out.println("Nell toGetDrammatico");
		List<Film> listaFilm = filmInterface.findPerCategoria(3);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetThriller(HttpServletRequest request) {
		System.out.println("Nell toGetThriller");
		List<Film> listaFilm = filmInterface.findPerCategoria(4);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetHorror(HttpServletRequest request) {
		System.out.println("Nell toGetHorror");
		List<Film> listaFilm = filmInterface.findPerCategoria(5);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetFantasy(HttpServletRequest request) {
		System.out.println("Nell toGetFantasy");
		List<Film> listaFilm = filmInterface.findPerCategoria(6);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	private void toGetDocumentario(HttpServletRequest request) {
		System.out.println("Nell toGetDocumentario");
		List<Film> listaFilm = filmInterface.findPerCategoria(7);
		request.getSession().setAttribute("listaFilm", listaFilm);
	}
	
	private void insertFilm(HttpServletRequest request) {		
		
		Utility util = new Utility();
		String idFilm = util.idGenerator();
		Film film = new Film(filmInterface.assegnaId(idFilm));
		
		String idRegista = util.idGenerator();
		Regista regista = new Regista(registaInterface.assegnaId(idRegista));
		regista.setNome(request.getParameter("nomeRegista"));
		regista.setCognome(request.getParameter("cognomeRegista"));	
		
		film.setTitolo(request.getParameter("titoloFilm"));
		film.setIdRegista(regista.getIdRegista());		
		Date data = util.formattaData(request.getParameter("dataFilm"));
		film.setAnno(data);	
		film.setClassificazione(request.getParameter("classificazioneFilm"));
		film.setNazionalita(request.getParameter("nazionalitaFilm"));		
		
		String[] generi = request.getParameterValues("id");
		List<Categoria> listaGeneri = new ArrayList<>(generi.length);		
		for ( int i = 0; i < generi.length; i++ ) {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(Integer.valueOf(generi[i]));
			listaGeneri.add(categoria);	
		}
		film.setIdRegista(regista.getIdRegista());
		film.setListaGeneriDelFilm(listaGeneri);
		filmInterface.insert(film,regista);
				
	}
	
	private void toDeleteFilm(HttpServletRequest request) {
		System.out.println("Nell toDeleteFilm");
		String idFilm = request.getParameter("idFilm");	
		Film film = filmInterface.findById(idFilm);
		System.out.println(film);
		System.out.println("elimino film");
		request.getSession().setAttribute("film", film);
		filmInterface.delete(film);
	}
	
	private void toUpdateFilm(HttpServletRequest request) {

		System.out.println("Nell toUpdate film");
		Utility util = new Utility();
		Film film = filmInterface.findById(request.getParameter("idFilm"));
		film.setTitolo(request.getParameter("titolo"));
		film.setAnno(util.formattaData(request.getParameter("anno")));
		Regista regista = new Regista();
		regista.setNome(request.getParameter("nomeRegista"));
		regista.setCognome(request.getParameter("cognomeRegista"));
		if ( registaInterface.findByNomeCognome(regista) == null ) {
			String idRegista = util.idGenerator();
			regista.setIdRegista(registaInterface.assegnaId(idRegista));
			film.setIdRegista(regista.getIdRegista());
			registaInterface.insert(regista);		
		}
		else {
			regista =registaInterface.findByNomeCognome(regista);;
			film.setIdRegista(regista.getIdRegista());
		}
		film.setClassificazione(request.getParameter("classificazione"));
		film.setNazionalita(request.getParameter("nazionalita"));		
		String[] generi = request.getParameterValues("id");
		List<Categoria> listaGeneri = new ArrayList<>(generi.length);		
		for ( int i = 0; i < generi.length; i++ ) {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(Integer.valueOf(generi[i]));
			listaGeneri.add(categoria);	
		}
		film.setListaGeneriDelFilm(listaGeneri);			
		request.getSession().setAttribute("film", film);		
		film = filmInterface.update(film);
	}
	
	private void toInfoFilm(HttpServletRequest request) {
		System.out.println("Nell info film");		
		String idFilm = request.getParameter("idFilm");
		Film film = filmInterface.findById(idFilm);		
		System.out.println(film);		
		request.getSession().setAttribute("film", film);
	}
	private void salvaFilmPerUpdate(HttpServletRequest request) {
		System.out.println("Nell update film");	
		String idFilm = request.getParameter("idFilm");	
		Film film = filmInterface.findById(idFilm);
		System.out.println(film);
		request.getSession().setAttribute("film", film);
	}
	
	private void rendiAministratore(HttpServletRequest request) {
		System.out.println("Nell rendi amministratore");
		String idUser = request.getParameter("idUser");
		User user = userInterface.findById(idUser);
		user.setRuolo(2);
		userInterface.update(user);
		System.out.println(user + " è passato ad amministratore");
		request.getSession().setAttribute("user", user);		
	}

}
