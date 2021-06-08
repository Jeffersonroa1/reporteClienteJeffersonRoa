package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;

import entidad.tipoCliente;
import util.MySqlDBConexion;

public class ClienteModel_Jefferson_Roa_Neira {

	
	public List<Cliente> consultaCliente(String dniJefferson){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Traemos la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "select c.* , t.nombre from cliente c inner join tipo_cliente t on c.idCliente = t.idTpoCliente where dni = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dniJefferson);
			
			rs = pstm.executeQuery();
					
			Cliente objCliente = null;
			tipoCliente objTipoCliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getInt(4));
				objCliente.setFechaNacimiento(rs.getDate(5));
				
				objTipoCliente = new tipoCliente();
				objTipoCliente.setIdTpoCliente(rs.getInt(6));
				objTipoCliente.setNombre(rs.getString(7));
				
				objCliente.setTipoCliente(objTipoCliente);
				
				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public List<Cliente> listaCliente(){		
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Traemos la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "select c.* , t.nombre from cliente c inner join tipo_cliente t on c.idCliente = t.idTpoCliente ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();		
				
			Cliente objCliente = null;
			tipoCliente objTipoCliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getInt(4));
				objCliente.setFechaNacimiento(rs.getDate(5));			
				
				objTipoCliente = new tipoCliente();
				objTipoCliente.setIdTpoCliente(rs.getInt(6));
				objTipoCliente.setNombre(rs.getString(7));
				
				objCliente.setTipoCliente(objTipoCliente);
				
				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
