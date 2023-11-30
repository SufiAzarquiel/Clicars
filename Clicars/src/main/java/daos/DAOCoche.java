package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Coche;

public class DAOCoche {
	public ArrayList<Coche> getCoches(Connection con, int marca, String orden) throws SQLException {
		ResultSet rs;
		ArrayList<Coche> lista = new ArrayList<Coche>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM coche";
		if (marca != 0) {
			ordenSql += " WHERE marca=" + marca;
		}
		if (orden != "") {
			ordenSql += " ORDER BY " + orden;
		}
		rs = st.executeQuery(ordenSql);
		System.out.println(ordenSql);

		while (rs.next()) {
			Coche coche = new Coche();
			coche.setId(rs.getInt("id"));
			coche.setMarca(rs.getInt("marca"));
			coche.setFoto(rs.getString("foto"));
			coche.setNombre(rs.getString("nombre"));
			coche.setModelo(rs.getString("modelo"));
			coche.setPrecio(rs.getInt("precio"));
			coche.setPrecioantes(rs.getInt("precioantes"));
			coche.setAnio(rs.getInt("anio"));
			coche.setKm(rs.getInt("km"));
			coche.setCv(rs.getInt("cv"));
			coche.setFav(rs.getInt("fav"));
			coche.setLikes(rs.getInt("likes"));

			/*
			 * Statement stMarca; stMarca = con.createStatement(); String ordenSqlMarca =
			 * "SELECT nombre from marca where id=" + rs.getInt("marca"); ResultSet rsMarca
			 * = stMarca.executeQuery(ordenSqlMarca); rsMarca.next();
			 * coche.setNombremarca(rsMarca.getString("nombre")); rsMarca.close();
			 */
			lista.add(coche);
		}
		rs.close();
		st.close();

		return lista;
	}

	public int actualizaFav(int idCoche, int currentFav, Connection con) throws SQLException {
		int actualizados = -1;
		int fav = (currentFav == 0) ? 1 : 0;
		String ordenSQL = "UPDATE coche SET fav=? where id=?";
		PreparedStatement st = con.prepareStatement(ordenSQL);
		st.setInt(1, fav);
		st.setInt(2, idCoche);
		actualizados = st.executeUpdate();
		st.close();

		return actualizados;
	}

}
