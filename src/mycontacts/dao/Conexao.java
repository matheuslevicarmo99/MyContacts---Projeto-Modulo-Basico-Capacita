package mycontacts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private static final String URL = "jdbc:sqlite:agenda.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS contatos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT NOT NULL,"
                + "telefone TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "empresa TEXT,"
                + "tipo TEXT NOT NULL"
                + ");";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela de contatos verificada/criada com sucesso no SQLite!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
}