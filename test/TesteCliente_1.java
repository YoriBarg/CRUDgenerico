
import interdisciplinar.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */

public class TesteCliente_1 {//teste unitario
@Test
    public void testSetAndGetPermissao() {
    Cliente cliente = new Cliente();
    cliente.setNome("Yuri");
    cliente.setEmail("yuri@email.com");
    cliente.setCSenha("12345");
    cliente.setPermissao(1);

    assertEquals("Yuri", cliente.getNome());
    assertEquals("yuri@email.com", cliente.getEmail());
    assertEquals("12345", cliente.getCSenha());
    assertEquals(1, cliente.getPermissao());
}
}