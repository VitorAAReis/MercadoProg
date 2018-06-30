/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oswaldo
 */
public class GerarConexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection conectar(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbclone", "root","110998Jl#A");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de conexão: " + ex);
            throw new RuntimeException("Erro de conexão");
        }
        
    }
    
    public static void desconectar(Connection con){
        
        try {
            if(con!=null){
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro no encerramento da conexão: "+ ex);
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt){
        desconectar(con);
        try {
            if(stmt!=null){
            stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro no encerramento da conexão: "+ ex);
        }
    }
    
    public static void desconectar(Connection con, PreparedStatement stmt, ResultSet rs){
        desconectar(con,stmt);
        try {
            if(rs!=null){
            rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro no encerramento da conexão: "+ ex);
        }
    }
}
