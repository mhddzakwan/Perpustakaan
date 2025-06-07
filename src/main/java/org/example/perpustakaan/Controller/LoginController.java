package org.example.perpustakaan.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.perpustakaan.Database.Db;
import org.example.perpustakaan.Model.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Label Wrong;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField inputEmail;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        Db db = new Db();
        String email = inputEmail.getText();
        String password = inputPassword.getText();

        String user = db.authenticateUser(email, password);

        if (user != "") {

            System.out.println("Login berhasil. nama : " + user);
            Admin.nama_user = user.split(" ")[0];
            // Simpan ID jika ingin digunakan di halaman berikutnya
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/perpustakaan/Dashboard.fxml"));
            Parent dashboard = loader.load();

            // Kirim ID ke dashboard jika perlu
            // DashboardController controller = loader.getController();
            // controller.setUserId(userId);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(dashboard));
            stage.show();
        } else {
            Wrong.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
