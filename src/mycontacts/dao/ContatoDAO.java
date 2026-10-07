package mycontacts.dao;

import mycontacts.model.Contato;
import mycontacts.model.ContatoComercial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements RepositorioGenerico<Contato> {

    public void inserir(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email, empresa, tipo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getEmail());

            if (contato instanceof ContatoComercial) {
                ContatoComercial cc = (ContatoComercial) contato;
                pstmt.setString(4, cc.getEmpresa());
                pstmt.setString(5, "COMERCIAL");
            } else {
                pstmt.setString(4, "");
                pstmt.setString(5, "PADRAO");
            }

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir contato no banco: " + e.getMessage());
        }
    }

    public List<Contato> listarTodos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String empresa = rs.getString("empresa");
                String tipo = rs.getString("tipo");

                if (tipo.equals("COMERCIAL")) {
                    contatos.add(new ContatoComercial(nome, telefone, email, empresa));
                } else {
                    contatos.add(new Contato(nome, telefone, email));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }
}