
import interdisciplinar.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */

public class TesteCliente {
@Test
    public void testSenha() {
        Cliente cliente = new Cliente();
        cliente.setCSenha("123");
        assertEquals("123", cliente.getCSenha(), "A senha retornada não é a esperada");
    }
}