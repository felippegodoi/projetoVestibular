/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.DAO;

import br.com.projetovestibular.model.Cep;
import br.com.projetovestibular.model.Cidade;
import br.com.projetovestibular.model.Email;
import br.com.projetovestibular.model.Pessoa;
import br.com.projetovestibular.model.Telefone;
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
public class PessoaDAOImpl {
    private Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    public Integer cadastrar(Pessoa pessoa){
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        Integer idPessoa = null;
        String sql = "INSERT INTO pessoa(nome_pessoa, cpf_pessoa, rg_pessoa, endereco_pessoa,"
                + "numero_endereco_pessoa, bairro_endereco_pessoa, motivo_pessoa,data_fim_pessoa,"
                + "observacao_pessoa,id_cidade,id_telefone)VALUES (?, ?, ?, ?, ?,?, ?, ?,"
                + "?, ?, ?, ?) returning id_pessoa;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfPessoa());
            stmt.setString(3, pessoa.getRgPessoa());
            stmt.setString(4, pessoa.getEnderecoPessoa());
            stmt.setString(5, pessoa.getNumeroEnderecoPessoa());
            stmt.setString(6, pessoa.getBairroEnderecoPessoa());
            stmt.setString(7, pessoa.getMotivoPessoa());
            stmt.setDate(8, new java.sql.Date(pessoa.getDataFimPessoa().getTime()));
            stmt.setString(9, pessoa.getObservacaoPessoa());
            stmt.setInt(10, pessoa.getCidade().getIdCidade());
                       
            
            rs = stmt.executeQuery();
            while(rs.next()){
                idPessoa = rs.getInt("id_pessoa");
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();            
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idPessoa;        
    }
    
     public List<Object> listar(){
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.* from pessoa p order by p.id_pessoa;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                Email email = new Email();
                Telefone telefone = new Telefone();
                Cep cep = new Cep();
                Cidade cidade = new Cidade();
                
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                pessoa.setCpfPessoa(rs.getString("cpf_pessoa"));
                pessoa.setRgPessoa(rs.getString("rg_pessoa"));
                pessoa.setEnderecoPessoa(rs.getString("endereco_pessoa"));       
                pessoa.setNumeroEnderecoPessoa(rs.getString("numero_endereco_pessoa"));
                pessoa.setBairroEnderecoPessoa(rs.getString("bairro_endereco_pessoa"));
                pessoa.setMotivoPessoa(rs.getString("motivo_pessoa"));
                pessoa.setDataFimPessoa(rs.getDate("data_fim_pessoa"));
                pessoa.setObservacaoPessoa(rs.getString("observacao_pessoa"));              
                
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                pessoa.setCidade(cidade);
                
                resultado.add(pessoa);
            }
    }catch(Exception ex){
        System.out.println("Problemas na DAO ao listar Pessoa! Erro: " + ex.getMessage());
        ex.printStackTrace();
    }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    return resultado;        
    }
     
     
     public Boolean alterarPessoa(Pessoa pessoa){
                  
        PreparedStatement stmt = null;
        String sql="update pessoa set nome_pessoa=?, cpf_pessoa=?, rg_pessoa=?, endereco_pessoa=?,"
                + "numero_endereco_pessoa=?, bairro_endereco_pessoa=?, motivo_pessoa=?,data_fim_pessoa=?,"
                + "observacao_pessoa=?, id_email=?, id_cep=?, id_cidade=?,id_telefone=? where id_pessoa=?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getCpfPessoa());
            stmt.setString(3, pessoa.getRgPessoa());
            stmt.setString(4, pessoa.getEnderecoPessoa());
            stmt.setString(5, pessoa.getNumeroEnderecoPessoa());
            stmt.setString(6, pessoa.getBairroEnderecoPessoa());
            stmt.setString(7, pessoa.getMotivoPessoa());
            stmt.setDate(8, new java.sql.Date(pessoa.getDataFimPessoa().getTime()));
            stmt.setString(9, pessoa.getObservacaoPessoa());     
            stmt.setInt(10, pessoa.getCidade().getIdCidade());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar Pessoa! Erro: "+ ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parametros de Conexão! Erro: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }
     }
              
}
