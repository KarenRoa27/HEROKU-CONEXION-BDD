/*
* Haga clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
* Haga clic en nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta plantilla
*/
package com.gavilan.clase7922;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Karen Yulied Bohorquez Roa // 20201578118
 */
public class Conexion {

    private Connection conectar;
    private String BD;
    private String usuario;
    private String contra;

    public Conexion(Connection conectar, String BD, String usuario, String contra) {
        this.conectar = conectar;
        this.BD = BD;
        this.usuario = usuario;
        this.contra = contra;
    }

        public Conexion() {
        this.conectar = null;
        this.BD = "bd_Bohorquez";
        this.usuario = "postgres";
        this.contra = "123456";
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.BD = "jdbc:postgresql://127.0.0.1:5432/bd_Bohorquez";
            this.usuario = "postgres";
            this.contra = "123456";
            this.conectar = (Connection) DriverManager.getConnection(BD, usuario, contra);
        } catch (ClassNotFoundException | HeadlessException | SQLException e) {

            System.out.println("Error al conectar: " + e);
        }
    }

    public Connection getConexion() {
        return conectar;
    }
}