package mycontacts;

import mycontacts.dao.Conexao;
import mycontacts.dao.ContatoDAO;
import mycontacts.model.Contato;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContatoDAOTest {

    private ContatoDAO dao;

    @BeforeEach
    public void prepararBanco() {
        Conexao.criarTabela();
        dao = new ContatoDAO();
        dao.inserir(new Contato("Teste", "85999999999", "teste@email.com"));
    }

    @AfterEach
    public void limparBanco() {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM contatos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveBuscarContatoInserido() {
        List<Contato> lista = dao.buscarPorNome("Teste");
        assertFalse(lista.isEmpty());
        assertEquals("Teste", lista.get(0).getNome());
    }
}