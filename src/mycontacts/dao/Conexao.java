package mycontacts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    // O caminho do arquivo do banco de dados que será gerado localmente
    private static final String URL = "jdbc:sqlite:agenda.db";

    // Método que "abre a porta" para o banco de dados
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e.getMessage());
            return null;
        }
    }

    // Método que constrói a tabela (se ela ainda não existir)
    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS contatos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "telefone TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "empresa TEXT,"       // Ficará vazio para contatos padrão
                + "tipo TEXT NOT NULL"  // Guardará "PADRAO" ou "COMERCIAL"
                + ");";

        // O try-with-resources (com parênteses) fecha a conexão automaticamente após o uso
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela de contatos verificada/criada com sucesso no SQLite!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}