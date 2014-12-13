/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.controller;

import br.com.projetovestibular.DAO.FuncionarioDAOImpl;
import br.com.projetovestibular.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Felippe
 */
public class LogarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("loginpessoa");
        String senha = request.getParameter("senhapessoa");
        String mensagem = null;
        
        if(request.getParameter("acao").equals("logar")){
            if(!login.equals("")|| !senha.equals("")){
                try{
                    FuncionarioDAOImpl dao = new FuncionarioDAOImpl();
                    Funcionario funcionario = dao.logarUsuario(login, senha);
                    if(funcionario != null){
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("idPessoa", funcionario.getIdPessoa());
                    sessao.setAttribute("nomePessoa", funcionario.getNomePessoa());
                    mensagem = "Seja Bem Vindo Sr.(a) "+ funcionario.getNomePessoa() + "!";
                    sessao.setAttribute("saudacao", mensagem);
                                        
                    request.getRequestDispatcher("painelusuario.jsp").forward(request, response);
                    
                }else{
                        mensagem = "Login/Senha Invalidos!";
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }                  
                    
                }catch(Exception ex){
                    System.out.println("Problemas ao Logar Usuário! Erro: "+ ex.getMessage());
                    ex.printStackTrace();
                }              
            }else{
                mensagem="Login/senha Inválidos!";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else if(request.getParameter("acao").equals("logout")){
             HttpSession sessao = request.getSession(true);
             sessao.invalidate();
             response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
