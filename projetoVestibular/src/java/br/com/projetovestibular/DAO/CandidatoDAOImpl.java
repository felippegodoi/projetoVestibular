/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.DAO;

import br.com.projetovestibular.model.Candidato;
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
public class CandidatoDAOImpl implements GenericDAO{
    private Connection conn;

    public CandidatoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    
    @Override
    public Boolean cadastrar(Object object) {
        Candidato candidato = (Candidato) object;
        PreparedStatement stmt = null;
        String sql = "Insert into candidato(status_candidato, motivo_candidato) values (?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, candidato.getStatusCandidato());
            stmt.setString(2, candidato.getMotivoCandidato());
             try {
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(3, daoPessoa.cadastrar(candidato));
            } catch (Exception ex) {
                System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
                stmt.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas na DAO ao cadastrar Candidato! Erro: " + ex.getMessage());
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
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.* from pessoa p ,candidato c "
                + "where p.id_pessoa = c.id_pessoa order by c.id_pessoa;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                Email email = new Email();
                Telefone telefone = new Telefone();
                Cep cep = new Cep();
                Cidade cidade = new Cidade();
                Candidato candidato = new Candidato();
                
                candidato.setIdPessoa(rs.getInt("id_pessoa"));
                candidato.setNomePessoa(rs.getString("nome_pessoa"));
                candidato.setCpfPessoa(rs.getString("cpf_pessoa"));
                candidato.setRgPessoa(rs.getString("rg_pessoa"));
                candidato.setEnderecoPessoa(rs.getString("endereco_pessoa"));       
                candidato.setNumeroEnderecoPessoa(rs.getString("numero_endereco_pessoa"));
                candidato.setBairroEnderecoPessoa(rs.getString("bairro_endereco_pessoa"));
                candidato.setMotivoPessoa(rs.getString("motivo_pessoa"));
                candidato.setDataFimPessoa(rs.getDate("data_fim_pessoa"));
                candidato.setObservacaoPessoa(rs.getString("observacao_pessoa"));
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                candidato.setCidade(cidade);
                                
                resultado.add(candidato);
            }
    }catch(Exception ex){
        System.out.println("Problemas na DAO ao listar Candidato! Erro: " + ex.getMessage());
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

     public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from candidato where id_pessoa = ?;"
                + "commit;"
                + "Delete from pessoa where id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas na DAO ao listar Candidato! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Candidato candidato = null;
        Pessoa pessoa = null;
        Email email = null;
        Telefone telefone = null;
        Cep cep = null;
        Cidade cidade = null;

        String sql = "Select p.*, c.* from pessoa p, candidato c "
                + "where p.id_pessoa = c.id_pessoa AND c.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                cidade = new Cidade();
                candidato = new Candidato();
                
                candidato.setIdPessoa(rs.getInt("id_pessoa"));
                candidato.setNomePessoa(rs.getString("nome_pessoa"));
                candidato.setCpfPessoa(rs.getString("cpf_pessoa"));
                candidato.setRgPessoa(rs.getString("rg_pessoa"));
                candidato.setEnderecoPessoa(rs.getString("endereco_pessoa"));       
                candidato.setNumeroEnderecoPessoa(rs.getString("numero_endereco_pessoa"));
                candidato.setBairroEnderecoPessoa(rs.getString("bairro_endereco_pessoa"));
                candidato.setMotivoPessoa(rs.getString("motivo_pessoa"));
                candidato.setDataFimPessoa(rs.getDate("data_fim_pessoa"));
                candidato.setObservacaoPessoa(rs.getString("observacao_pessoa"));
        
                
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                candidato.setCidade(cidade);
                                         

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Candidato! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return candidato;
    }   

    @Override
    public Boolean alterar(Object object) {
        Candidato candidato = (Candidato) object;
        PreparedStatement stmt = null;
        String sql = "update candidato set status_candidato = ?, motivo_candidato = ? where id_pessoa = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
                stmt.setString(1, candidato.getStatusCandidato());
                stmt.setString(2, candidato.getMotivoCandidato());
                stmt.setInt(3, candidato.getIdPessoa());
            try{
                   PessoaDAOImpl dao = new PessoaDAOImpl();
                   if(dao.alterarPessoa(candidato)){
                       stmt.executeUpdate();
                       return true;
                   }
                   else{
                       return false;
                   }
               }catch(Exception ex){
                   System.out.println("Problemas ao Alterar Candidato! Erro: "+ ex.getMessage());
                   ex.printStackTrace();
                   return false;
               }
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar Candidato! Erro: "+ ex.getMessage());
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
