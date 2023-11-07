package com.company.repositoryDao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection CERRAR_CONEXION(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
		return con;
	}
}
