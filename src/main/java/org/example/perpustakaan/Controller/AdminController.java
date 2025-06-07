package org.example.perpustakaan.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.perpustakaan.Database.Db;
import org.example.perpustakaan.Model.Admin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class AdminController implements Initializable {
    Db db = new Db();

    @FXML private Button btnAdmin,btnBook,btnDashboard,btnIssue,btnReserved,btnMember, btnCategory, btnReturn, btnName;

    @FXML
    private TableView<Admin> tableAdmin;

    @FXML
    private TableColumn<Admin, Integer> colId;

    @FXML
    private TableColumn<Admin, String> colName, colEmail, colPhone;

    private ObservableList<Admin> adminList = FXCollections.observableArrayList();

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void handleClicks(ActionEvent event) throws Exception {
        Parent page = null;

        if(event.getSource() == btnDashboard){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Dashboard.fxml"));
        }else if(event.getSource() == btnAdmin){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Admin.fxml"));
        }else if(event.getSource() == btnMember){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Member.fxml"));
        }else if(event.getSource() == btnCategory){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Category.fxml"));
        }else if(event.getSource() == btnBook){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Book.fxml"));
        }else if(event.getSource() == btnReserved){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Reserve.fxml"));
        } else if(event.getSource() == btnIssue){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Issue.fxml"));
        }else if(event.getSource() == btnReturn){
            page = FXMLLoader.load(getClass().getResource("/org/example/perpustakaan/Return.fxml"));
        }
        Scene bookScene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(bookScene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Bind kolom ke property di class Admin
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        btnName.setText("Hi, " + Admin.nama_user + "!");
        ArrayList<Admin> admins = db.getAdminList();
         ObservableList<Admin> observableAdmins = FXCollections.observableArrayList(admins);
        tableAdmin.setItems(observableAdmins);
    }
}
