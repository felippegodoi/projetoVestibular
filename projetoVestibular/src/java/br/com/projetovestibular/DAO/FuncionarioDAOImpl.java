/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.DAO;

import br.com.projetovestibular.model.Cargo;
import br.com.projetovestibular.model.Funcionario;
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
public class FuncionarioDAOImpl implements GenericDAO{
    private Connection conn;
    
    
     public FuncionarioDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO funcionario(matricula_funcionario, "
                + "login_funcionario, senha_funcionario, "
                + "id_cargo, id_pessoa) VALUES (?, ?, ?, ?, ?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getMatriculaFuncionario());
            stmt.setString(2, funcionario.getLoginFuncionario());
            stmt.setString(3, funcionario.getSenhaFuncionario());            
            stmt.setInt(4, funcionario.getCargo().getIdCargo());
            try{
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(5, daoPessoa.cadastrar(funcionario));
            }catch(Exception ex){
                System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            stmt.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao cadastrar Funcionario! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parâmetros de conexão!Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }          
    }
   

    @Override
    public List<Object> listar() {
        
        List<Object> resultado = new ArrayList<Object>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, f.*, c.nome_cargo from pessoa p ,funcionario f, cargo c  where p.id_pessoa = f.id_pessoa and f.id_cargo = c.id_cargo order by f.nome_cargo;";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                Funcionario funcionario = new Funcionario();
                Cargo cargo = new Cargo();
                
                funcionario.setIdPessoa(rs.getInt("id_pessoa"));
                funcionario.setNomePessoa(rs.getString("nome_pessoa"));
                funcionario.setCpfPessoa(rs.getString("cpf_pessoa"));
                funcionario.setRgPessoa(rs.getString("rg_pessoa"));
                funcionario.setEnderecoPessoa(rs.getString("endereco_pessoa"));       
                funcionario.setNumeroEnderecoPessoa(rs.getString("numero_endereco_pessoa"));
                funcionario.setBairroEnderecoPessoa(rs.getString("bairro_endereco_pessoa"));
                funcionario.setMotivoPessoa(rs.getString("motivo_pessoa"));
                funcionario.setDataFimPessoa(rs.getDate("data_fim_pessoa"));
                funcionario.setObservacaoPessoa(rs.getString("observacao_pessoa"));
                funcionario.setMatriculaFuncionario(rs.getString("matricula_funcionario"));
                funcionario.setLoginFuncionario(rs.getString("login_funcionario"));
                funcionario.setSenhaFuncionario(rs.getString("senha_funcionario"));
                
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNomeCargo(rs.getString("nome_cargo"));   
                funcionario.setCargo(cargo);
                
                resultado.add(funcionario);
            }
    }catch(Exception ex){
        System.out.println("Problemas na DAO ao listar Funcionario! Erro: " + ex.getMessage());
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
    

    @Override
    public void excluir(int idObject) {
    PreparedStatement stmt = null;
    String sql="Delete from funcionario where id_pessoa = ?;"
            + "commit;"
            + "Delete from pessoa where id_pessoa = ?;";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idObject);
        stmt.setInt(2, idObject);
        stmt.executeUpdate();
    }catch(SQLException ex){
        System.out.println("Problemas na DAO ao Excluir Funcionario! Erro: " + ex.getMessage());
        ex.printStackTrace();
    }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    
    
    
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        Cargo cargo = null;
        String sql="Select p.*, f.* , c.nome_cargo from pessoa p, funcionario f, cargo c where p.id_pessoa = f.id_pessoa AND "
                + "f.id_cargo = c.id_cargo AND f.id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs=stmt.executeQuery();
            while(rs.next()){
            funcionario = new Funcionario();
                cargo = new Cargo();
                
                funcionario.setIdPessoa(rs.getInt("id_pessoa"));
                funcionario.setNomePessoa(rs.getString("nome_pessoa"));
                funcionario.setCpfPessoa(rs.getString("cpf_pessoa"));
                funcionario.setRgPessoa(rs.getString("rg_pessoa"));
                funcionario.setEnderecoPessoa(rs.getString("endereco_pessoa"));       
                funcionario.setNumeroEnderecoPessoa(rs.getString("numero_endereco_pessoa"));
                funcionario.setBairroEnderecoPessoa(rs.getString("bairro_endereco_pessoa"));
                funcionario.setMotivoPessoa(rs.getString("motivo_pessoa"));
                funcionario.setDataFimPessoa(rs.getDate("data_fim_pessoa"));
                funcionario.setObservacaoPessoa(rs.getString("observacao_pessoa"));
                funcionario.setMatriculaFuncionario(rs.getString("matricula_funcionario"));
                funcionario.setLoginFuncionario(rs.getString("login_funcionario"));
                funcionario.setSenhaFuncionario(rs.getString("senha_funcionario"));
                
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNomeCargo(rs.getString("nome_cargo"));   
                funcionario.setCargo(cargo);
            
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao carregar Funcionario! Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parametros de Conexão! Erro: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }
        return funcionario;
    }

    @Override
    public Boolean alterar(Object object) {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql="UPDATE funcionario SET  matricula_funcionario=?, login_funcionario=?, "
                + "senha_funcionario=?, id_cargo=? WHERE id_pessoa=?;";
        
        try{
            stmt = conn.prepareStatement(sql);
               
               stmt.setString(1,funcionario.getMatriculaFuncionario());
               stmt.setString(2,funcionario.getLoginFuncionario());
               stmt.setString(3,funcionario.getSenhaFuncionario());
               stmt.setInt(4, funcionario.getCargo().getIdCargo());
               stmt.setInt(5, funcionario.getIdPessoa());
               try{
                   PessoaDAOImpl dao = new PessoaDAOImpl();
                   if(dao.alterarPessoa(funcionario)){
                       stmt.executeUpdate();
                       return true;
                   }
                   else{
                       return false;
                   }
               }catch(Exception ex){
                   System.out.println("Problemas ao Alterar Pessoa! Erro: "+ ex.getMessage());
                   ex.printStackTrace();
                   return false;
               }
        }catch (SQLException ex){
            System.out.println("Problemas ao alterar Funcionario! Erro: "+ ex.getMessage());
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

    public Funcionario logarUsuario(String login, String senha){
         PreparedStatement stmt = null;
         ResultSet rs = null;
         Funcionario funcionario = null;
         
         String sql = "Select * from funcionario f where f.login_funcionario = ? AND f.senha_funcionario = ?;";
         try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while(rs.next()){
                funcionario = new Funcionario();
                funcionario.setIdPessoa(rs.getInt("id_pessoa"));
                funcionario.setNomePessoa(rs.getString("nome_pessoa"));
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setLoginFuncionario(rs.getString("login_funcionario"));
                funcionario.setSenhaFuncionario(rs.getString("senha_funcionario"));                
                
            }
    }catch(Exception ex){
        System.out.println("Problemas na DAO ao listar Funcionario! Erro: " + ex.getMessage());
        ex.printStackTrace();
    }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de Conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    return funcionario;        
    }
       
}
