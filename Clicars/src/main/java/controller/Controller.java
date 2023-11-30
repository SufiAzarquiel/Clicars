package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Conexion;
import daos.DAOCoche;
import daos.DAOMarca;
import model.Coche;
import model.Marca;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idmarca = 0;
	private String orden = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		ArrayList<Marca> marcas = null;
		ArrayList<Coche> coches = null;

		// Singleton connection
		Connection con = (Connection) session.getAttribute("con");
		if (con == null) {
			try {
				con = Conexion.conecta();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("con", con);
		}

		switch (op) {
		case "inicio": {
			try {
				coches = new DAOCoche().getCoches(con, 0, "");
				marcas = new DAOMarca().getAllMarcas(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			session.setAttribute("marcas", marcas);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "vamarca": {
			idmarca = Integer.parseInt(request.getParameter("marca"));
			try {
				coches = new DAOCoche().getCoches(con, idmarca, orden);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "vaorden": {
			orden = request.getParameter("orden");
			try {
				coches = new DAOCoche().getCoches(con, idmarca, orden);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "addlike": {
			int id = Integer.parseInt(request.getParameter("id"));
			int likes = Integer.parseInt(request.getParameter("likes"));
			int fav = Integer.parseInt(request.getParameter("fav"));
			try {
				DAOCoche dc = new DAOCoche();
				if (fav == 0) {
					dc.addLike(id, likes, con);
				}
				coches = dc.getCoches(con, idmarca, orden);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
