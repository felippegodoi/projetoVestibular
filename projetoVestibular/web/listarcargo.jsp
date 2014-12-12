<%-- 
    Document   : listarcargo
    Created on : 11/12/2014, 23:10:10
    Author     : Felippe
--%>

<%@page import="br.com.projetovestibular.model.Cargo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Listar Cargos</title>
    </head>
    <body id="body">
              
        <h1 align="center">Lista de Cargos</h1>
        
        <table align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Cargo</th>
                </tr>
            </thead>
            
            <tbody>
                <%
                    List<Cargo> cargos =(List<Cargo>)
                            request.getAttribute("cargos");
                    for(Cargo cargo : cargos){
                    
                    %>
                    <tr>
                        <td><%= cargo.getIdCargo() %></td>
                        <td><%= cargo.getNomeCargo() %></td>
                        <td><a href="ExcluirCargo?idcargo=<%= cargo.getIdCargo() %>">Excluir</a></td>
                        <td><a href="CarregarCargo?idcargo=<%= cargo.getIdCargo() %>">Alterar</a></td>
                    </tr>
                    <% } %>
            </tbody>
            
        </table>
            
    </body>
</html>