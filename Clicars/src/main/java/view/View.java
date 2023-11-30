package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexion;
import daos.DAOMarca;
import model.Marca;

public class View {
	public static void main(String[] args) {
		try {
			Connection con = Conexion.conecta();
			ArrayList<Marca> marcas = new DAOMarca().getAllMarcas(con);
			for (Marca marca : marcas) {
				System.out.println(marca);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
