package mycontacts.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mycontacts.dao.Conexao;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Conexao.criarTabela();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mycontacts/view/agenda.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 450);

        stage.setTitle("MyContacts - Interface Gráfica");
        stage.setScene(scene);
        stage.show();
    }
}