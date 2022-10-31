package com.gavilan.clase7922;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karen Yulied Bohorquez Roa // 20201578118
 */
public class PersonaDAO {

      private static final String SQL_READALL = "SELECT * FROM tb_persona ";
 
    public PersonaDAO() {
     
    }

    public List<PersonaDTO> readAll() {
        Conexion con= new Conexion();
        con.conectar();
        List<PersonaDTO> lista = null;
        PreparedStatement ps;
        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                PersonaDTO obj = new PersonaDTO(rs.getString("nombres"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("clave"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex);
        }
        return lista;
    }
}
