package mycontacts.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mycontacts.dao.ContatoDAO;
import mycontacts.model.Contato;
import mycontacts.model.ContatoComercial;

public class AgendaController {

    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEmpresa;

    @FXML private TableView<Contato> tabelaContatos;
    @FXML private TableColumn<Contato, String> colNome;
    @FXML private TableColumn<Contato, String> colTelefone;
    @FXML private TableColumn<Contato, String> colEmail;

    private ContatoDAO dao = new ContatoDAO();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        carregarContatos();
    }

    @FXML
    public void adicionarContato() {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String empresa = txtEmpresa.getText();

        if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
            Contato contato;
            if (empresa != null && !empresa.isEmpty()) {
                contato = new ContatoComercial(nome, telefone, email, empresa);
            } else {
                contato = new Contato(nome, telefone, email);
            }

            dao.inserir(contato);

            txtNome.clear(); txtTelefone.clear(); txtEmail.clear(); txtEmpresa.clear();
            carregarContatos();
        }
    }

    public void carregarContatos() {
        ObservableList<Contato> contatos = FXCollections.observableArrayList(dao.listarTodos());
        tabelaContatos.setItems(contatos);
    }
}