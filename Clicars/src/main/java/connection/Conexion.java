package connection;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Conexion {
	public static Connection conecta() throws SQLException {
		// change username password please
		// 80.28.158.14 ip donde se ubica el Oracle Server del Azarquiel
		// 1521:oradai, puerto default Oracle y servicio creado en este Server
		String url = "jdbc:oracle:thin:clicars/clicars@80.28.158.14:1521:oradai";

		OracleConnectionPoolDataSource ocpds;
		Connection con = null;
		ocpds = new OracleConnectionPoolDataSource();
		ocpds.setURL(url);
		con = ocpds.getConnection();

		return con;
	}
}
