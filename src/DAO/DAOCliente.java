/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import conexao.ConexaoMySql;
import interdisciplinar.Cliente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yurib
 */
public class DAOCliente {
    public int salvarCliente(Cliente cliente) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "INSERT INTO cliente (email,nome,senha) VALUES("
                            + "'" + cliente.getEmail() + "',"
                            + "'" + cliente.getNome() + "',"
                            + "'" + cliente.getCSenha() + "'"
                            + ");";
        System.out.println("SQL gerado: " + sql);  // debug

            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }

    }

    public boolean excluirCliente(String email,String csenha) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "DELETE FROM cliente WHERE email = '" + email + "' AND senha = '" + csenha + "';";

            return conexao.executarUpdateDeleteSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }

    }

    public List<Cliente> listar() throws SQLException {

        List<Cliente> clientes = new ArrayList<Cliente>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("select * from cliente");

        while(rs.next()){
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setEmail(rs.getString("email"));
            c.setNome(rs.getString("nome"));
            c.setCSenha(rs.getString("senha"));
            clientes.add(c);
        }
        return clientes;
    }
    //altera o nome, endereco e telefone do cliente na base de dados com base no cpf
    public boolean alterarCliente(String email, String nome, String csenha) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql =
                    "UPDATE cliente SET nome = '" + nome +
                            "', senha = '" + csenha +
                            "' WHERE email = '"+ email + "';";

            return conexao.executarUpdateDeleteSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }

    }

    public Cliente getByEmail(String email, String csenha) throws  SQLException{
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM cliente WHERE email = '" + email + "' AND senha = '" + csenha + "'");

        if(rs.next()){
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNome(rs.getString("nome"));
            c.setCSenha(rs.getString("senha"));
            c.setEmail(rs.getString("email"));
            return c;
        }
        return null;
    }
    
}
