/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.DAO;

import br.com.projetovestibular.model.Email;
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
public class EmailDAOImpl implements GenericDAO{
    
    private Connection conn;
    
    public EmailDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso!!!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Email email = (Email) object;
        PreparedStatement stmt = null;
        String sql = "Insert into email(nome_email,data_fim_email,motivo_email, id_pessoa) values (?, ?, ?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email.getNomeEmail());
            stmt.setDate(2, new java.sql.Date(email.getDataFimEmail().getTime()));
            stmt.setString(3, email.getMotivoEmail());
            stmt.setInt(4, email.getPessoa().getIdPessoa());
            stmt.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas na DAO ao cadastrar Email;! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }           
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
