package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Marca;

public class DAOMarca {
	public ArrayList<Marca> getAllMarcas(Connection con) throws SQLException {
		ResultSet rs;
		ArrayList<Marca> lista = new ArrayList<Marca>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM marca";
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			lista.add(marca);
		}
		rs.close();
		st.close();

		return lista;
	}
}
