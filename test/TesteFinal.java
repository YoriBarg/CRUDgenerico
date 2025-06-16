
import controller.ClienteController;
import interdisciplinar.Cliente;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.assertEquals;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */
public class TesteFinal {
    @Test
public void testFluxoCompletoCadastroLoginExclusao() throws SQLException {
    ClienteController controller = new ClienteController();

    Cliente cliente = new Cliente();
    cliente.setEmail("teste@teste.com");
    cliente.setNome("Usuario 1");
    cliente.setCSenha("senha123");
    cliente.setPermissao(0);
    int resultado = controller.salvarCliente(cliente);
    assertTrue("Falha ao cadastrar Usuario", resultado > 0);

    Cliente logado = controller.buscarCliente("teste@teste.com", "senha123");
    assertNotNull("Usuario não encontrado", logado);
    assertEquals("Usuario 1", logado.getNome());
    
    boolean excluido = controller.excluirCliente("teste@teste.com", "senha123");
    assertTrue("Falha ao excluir cliente", excluido);
}
}
