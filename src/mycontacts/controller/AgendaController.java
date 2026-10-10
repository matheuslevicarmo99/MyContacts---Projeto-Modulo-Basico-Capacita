package mycontacts.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mycontacts.dao.ContatoDAO;
import mycontacts.exceptions.FormatoInvalidoException;
import mycontacts.model.Contato;
import mycontacts.model.ContatoComercial;
import mycontacts.utils.Validador;

import java.util.List;
import java.util.stream.Collectors;

public class AgendaController {

    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEmpresa;
    @FXML private TextField txtBusca;
    @FXML private ComboBox<String> cbFiltro;

    @FXML private TableView<Contato> tabelaContatos;
    @FXML private TableColumn<Contato, String> colNome;
    @FXML private TableColumn<Contato, String> colTelefone;
    @FXML private TableColumn<Contato, String> colEmail;
    @FXML private TableColumn<Contato, String> colEmpresa;

    private ContatoDAO dao = new ContatoDAO();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        colEmpresa.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof ContatoComercial) {
                return new SimpleStringProperty(((ContatoComercial) cellData.getValue()).getEmpresa());
            } else {
                return new SimpleStringProperty("Padrão");
            }
        });

        carregarContatos();
    }

    @FXML
    public void adicionarContato() {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String empresa = txtEmpresa.getText();

        if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
            try {
                Validador.validarTelefone(telefone);
                Validador.validarEmail(email);

                Contato contato;
                if (empresa != null && !empresa.isEmpty()) {
                    contato = new ContatoComercial(nome, telefone, email, empresa);
                } else {
                    contato = new Contato(nome, telefone, email);
                }

                dao.inserir(contato);

                txtNome.clear(); txtTelefone.clear(); txtEmail.clear(); txtEmpresa.clear();
                carregarContatos();

            } catch (FormatoInvalidoException e) {
                exibirAlerta("Erro de Validação", e.getMessage());
            }
        } else {
            exibirAlerta("Campos Vazios", "Por favor, preencha nome, telefone e e-mail.");
        }
    }

    @FXML
    public void carregarContatos() {
        ObservableList<Contato> contatos = FXCollections.observableArrayList(dao.listarTodos());
        tabelaContatos.setItems(contatos);
        if (txtBusca != null) txtBusca.clear();
        if (cbFiltro != null) cbFiltro.setValue("Todos");
    }

    @FXML
    public void buscarContato() {
        String nomeBusca = txtBusca.getText();
        if (!nomeBusca.isEmpty()) {
            ObservableList<Contato> contatos = FXCollections.observableArrayList(dao.buscarPorNome(nomeBusca));
            tabelaContatos.setItems(contatos);
        }
    }

    @FXML
    public void filtrarContatos() {
        String filtro = cbFiltro.getValue();
        List<Contato> todos = dao.listarTodos();
        List<Contato> filtrados;

        if (filtro.equals("Comercial")) {
            filtrados = todos.stream().filter(c -> c instanceof ContatoComercial).collect(Collectors.toList());
        } else if (filtro.equals("Padrão")) {
            filtrados = todos.stream().filter(c -> !(c instanceof ContatoComercial)).collect(Collectors.toList());
        } else {
            filtrados = todos;
        }

        tabelaContatos.setItems(FXCollections.observableArrayList(filtrados));
    }

    @FXML
    public void removerContato() {
        Contato selecionado = tabelaContatos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            dao.remover(selecionado.getNome());
            carregarContatos();
        } else {
            exibirAlerta("Nenhum Contato Selecionado", "Clique em um contato na tabela para remover.");
        }
    }

    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}