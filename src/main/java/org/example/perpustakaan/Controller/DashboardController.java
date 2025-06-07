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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.perpustakaan.Database.BookDb;
import org.example.perpustakaan.Model.Admin;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.print.*;
import java.io.*;

public class DashboardController implements Initializable {

    @FXML
    private Button btnAdmin,btnBook,btnDashboard,btnIssue,btnReserved,btnMember, btnCategory, btnReturn, btnName;
    @FXML
    private Label totalBook, totalBorrow, totalReturn, totalCategory, totalAdmin, totalMember;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    BookDb db = new BookDb();

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
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        logger.info("TOmbol: " + event.getSource().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalBook.setText(db.countDashboard("copy_buku"));
        totalBorrow.setText(db.countDashboard("peminjaman", "status = 'Dipinjam' "));
        totalReturn.setText(db.countDashboard("peminjaman", "status = 'Dikembalikan' "));
        totalCategory.setText(db.countDashboard("kategori"));
        totalAdmin.setText(db.countDashboard("admin"));
        totalMember.setText(db.countDashboard("anggota"));

        btnName.setText("Hi, " + Admin.nama_user + "!");


    }


}