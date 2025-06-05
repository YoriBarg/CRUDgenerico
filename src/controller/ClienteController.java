/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.DAOCliente;
import interdisciplinar.Cliente;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author yurib
 */
public class ClienteController {
        public int salvarCliente(Cliente cCliente){
        return new DAOCliente().salvarCliente(cCliente);
    }
    public boolean excluirCliente(String email,String csenha){
        return new DAOCliente().excluirCliente(email, csenha);
    }
    public boolean alterarCliente(String email, String nome, String csenha){
        return new DAOCliente().alterarCliente(email, nome, csenha);
    }
    public List<Cliente> listarCliente() throws SQLException {
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = dao.listar();
        return clientes;
    }
    public Cliente buscarCliente(String email, String csenha) throws SQLException{
        DAOCliente dao = new DAOCliente();
        Cliente cliente = dao.getByEmail(email,csenha);
        return cliente;
}
}