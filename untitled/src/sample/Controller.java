package sample;

import Connection.ConnectionClass;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller{
    @FXML private TextField txbEmail;
    @FXML private TextField txbPassword;
    @FXML private Button btnLogin;
    @FXML private Button btnRegister;



    @FXML
    void onLogin(ActionEvent event) throws SQLException, IOException {
        ConnectionClass con = new ConnectionClass();
        Connection connective = con.getConnection();
        String secondQuery = "select stdName from tbllogin WHERE stdName ='"+ txbEmail.getText() + "'" ;
        String queryPass = "select stdPassword from tbllogin WHERE stdPassword ='"+ txbPassword.getText() + "'";
        Statement stmt = connective.createStatement();
        Statement stmt1 = connective.createStatement();
        Statement stmt2 = connective.createStatement();

        ResultSet emailPass = stmt1.executeQuery(secondQuery);
        ResultSet pass = stmt2.executeQuery(queryPass);
        ResultSetMetaData rsmd = (ResultSetMetaData) emailPass.getMetaData();
        ResultSetMetaData password = (ResultSetMetaData) pass.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        int columnsPass = password.getColumnCount();
        String columnValue = null;
        while (emailPass.next()) {                                //
            for (int i = 1; i <= columnsNumber; i++) {           //
                if (i > 1) System.out.print(",  ");             //  FOR EMAIL
                columnValue = emailPass.getString(i);          //
                //System.out.print(columnValue);              //
            }
            //System.out.println("");
        }
        System.out.println(columnValue);
        String columnValue1 = null;
        while (pass.next()) {                               //
            for (int i = 1; i <= columnsPass; i++) {       //
                if (i > 1) System.out.print(",  ");       //
                columnValue1 = pass.getString(i);        //    FOR PASSWORD
                //System.out.print(columnValue1);       //
            }                                          //
            System.out.println("");                   //
        }
        System.out.println(columnValue1);


        // Check for availability in the table
        if (txbEmail.getText().equals(columnValue) && txbPassword.getText().equals(columnValue1) ){
            Parent secondRoot = FXMLLoader.load(getClass().getResource("menuBar.fxml"));
            Scene sceneSecond = new Scene(secondRoot);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(sceneSecond);
            window.show();


        }

        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("ERROR");
            errorAlert.setContentText("Not found");
            errorAlert.showAndWait();
        }


    }

    //This button is located on registration page and store everything to database



// This button open a registration page
    @FXML
    void onRegister(ActionEvent event) throws IOException {
        Parent secondRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene sceneSecond = new Scene(secondRoot);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneSecond);
        window.show();

    }


}
