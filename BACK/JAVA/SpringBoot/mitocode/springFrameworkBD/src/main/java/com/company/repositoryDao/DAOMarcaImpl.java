package com.company.repositoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.entityBeans.Marca;

@Repository
public class DAOMarcaImpl implements DAOMarca {

	@Autowired //La instancia la hace cuando lee el archivo de configuracion "beans.xml" en el BEAN[id="dataSource"]
	private DataSource dataSource;

	@Override
	public void registrar(Marca marca) throws Exception {
		String sql = "INSERT INTO marca (id, nombre) VALUES (?, ?)";
		Connection con = null; 

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, marca.getId());
			ps.setString(2, marca.getNombre());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw e;
		} finally {
			/*if (con != null) {
				con.close();
			}*/
			con = ConexionBD.CERRAR_CONEXION(con);
		}
	}

}
