/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.DAO;

import br.com.projetovestibular.model.Cargo;
import br.com.projetovestibular.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felippe
 */
public class CargoDAOImpl implements GenericDAO{
private Connection conn;
       
       public CargoDAOImpl() throws Exception{
           try{
               this.conn = ConnectionFactory.getConnection();
               System.out.println("Conectado com Sucesso!");
           }catch(Exception ex){
               throw new Exception(ex.getMessage());
       }
       }
    
    @Override
    public Boolean cadastrar(Object object) {
       Cargo cargo = (Cargo) object;
       PreparedStatement stmt = null;
       String sql = "Insert into cargo(nome_cargo) values(?);";
       try{
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, cargo.getNomeCargo());
           stmt.execute();
           return true;
       }catch(SQLException ex){
           System.out.println("Problemas na DAO ao Cadastrar Cargo! Erro: " + ex.getMessage());
           ex.printStackTrace();
           return false;
       }finally{
           try{
               ConnectionFactory.closeConnection(conn, stmt);
           }catch(Exception ex){
               
               System.out.println("Problemas ao Fechar Parametros de Conexão! Erro: " + ex.getMessage());
               ex.printStackTrace();
           }
       }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.* from cargo c order by c.nome_cargo;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
                while(rs.next()){
                    Cargo cargo = new Cargo();
                    cargo.setIdCargo(rs.getInt("id_cargo"));
                    cargo.setNomeCargo(rs.getString("nome_cargo"));
                    resultado.add(cargo);
            }
        }catch(Exception ex){
            System.out.println("Problemas na DAO ao listar Cargo! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de Conexão! Erro: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }   
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        
    PreparedStatement stmt = null;
    
    String sql = "delete from cargo where id_cargo=?;";
    
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idObject);
        stmt.executeUpdate();
    }catch(SQLException ex){
        System.out.println("Problemas na Dao ao Excluir Cargo! Erro: " + ex.getMessage());
        ex.printStackTrace();
    }finally{
        try{
            ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao Fechar Parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cargo cargo = null;
        String sql = "select c.* from cargo where c.id_cargo = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while(rs.next()){
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNomeCargo(rs.getString("nome_cargo"));
            }
        }catch(Exception ex){
            System.out.println("Problemas ao Carregar Cargo! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao Fechar Parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cargo;
    }

    @Override
    public Boolean alterar(Object object) {
        Cargo cargo = (Cargo) object;
        PreparedStatement stmt = null;
        String sql = "update cargo set nome_cargo = ? where id_cargo = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cargo.getNomeCargo());
            stmt.setInt(2, cargo.getIdCargo());
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            System.out.println("Problemas ao alterar cargo! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parametros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        }
    
}
