/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oswaldo
 */
public class ProdutoDAO {
    
    public static void criar(int id, String nome, double preco){
        Connection con = GerarConexao.conectar();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO clone(id,`nome`,preco) VALUES (?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setDouble(3, preco);
            stmt.executeUpdate();
            ProdutoDAO.ler();
        }catch (SQLException e){
            System.out.println("Erro na criação: " + e);
        }finally{
            GerarConexao.desconectar(con, stmt);
        }
    }
    
    public static void ler(){
        Connection con = GerarConexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement("SELECT id,`nome`,preco FROM mercadinho");
            rs = stmt.executeQuery();
            ListaProduto.novoHash();
            while(rs.next()){
                ListaProduto.carregarClone(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
            }
        }catch(SQLException e){
            System.out.println("Falha na leitura: " + e);
        }finally{
            GerarConexao.desconectar(con, stmt, rs);
        }
    }
    
    public void remover(int id){
        Connection con = GerarConexao.conectar();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("DELETE FROM mercadinho WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            this.ler();
        }catch(SQLException e){
            System.out.println("Falha na exclusão: " + e);
        }finally{
            GerarConexao.desconectar(con, stmt);
        }
    }
    
    public void alterar(int id, String nome, double preco){
        Connection con = GerarConexao.conectar();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE clone SET id=?, `nome`=?, preco=? WHERE id=?");
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setDouble(3, preco);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            this.ler();
        }catch(SQLException e){
            System.out.println("Falha na alteração: " + e);
        }finally{
            GerarConexao.desconectar(con, stmt);
        }
    }
}
