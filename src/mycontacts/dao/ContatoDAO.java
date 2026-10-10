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
            System.out.println(e.getMessage());
        }
    }

    public List<Contato> listarTodos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                contatos.add(montarContato(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contatos;
    }

    public void remover(String nome) {
        String sql = "DELETE FROM contatos WHERE nome = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Contato> buscarPorNome(String nomeBusca) {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos WHERE nome LIKE ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nomeBusca + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    contatos.add(montarContato(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contatos;
    }

    private Contato montarContato(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String telefone = rs.getString("telefone");
        String email = rs.getString("email");
        String empresa = rs.getString("empresa");
        String tipo = rs.getString("tipo");

        if (tipo.equals("COMERCIAL")) {
            return new ContatoComercial(nome, telefone, email, empresa);
        }
        return new Contato(nome, telefone, email);
    }
    public void inserirVarios(List<? extends Contato> entidades) {
        for (Contato c : entidades) {
            inserir(c);
        }
    }
}