package sample;

import Connection.ConnectionClass;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegiterController {
    @FXML private TextField txtName;
    @FXML private TextField txtSurname;
    @FXML private TextField txtEmail;
    @FXML private TextField txtPassword;
    @FXML private Button registerBtn;
    @FXML private Button backBtn;


    @FXML
    void onRegistration(ActionEvent event) throws SQLException {
        ConnectionClass con = new ConnectionClass();
        Connection connective = con.getConnection();
        String numberID = "select stdId from  tbllogin order by stdId DESC limit 1";
        Statement stmt = connective.createStatement();
        ResultSet iid = stmt.executeQuery(numberID);
        ResultSetMetaData myResult = (ResultSetMetaData) iid.getMetaData();
        int columnsNumber1 = myResult.getColumnCount();
        String columnValue2 = null;
        while (iid.next()) {
            for (int i = 1; i <= columnsNumber1; i++) {
                if (i > 1) System.out.print(",  ");
                columnValue2 = iid.getString(i);
                System.out.print(columnValue2);
            }
            //System.out.println("");
        }
        //int id = 3;
        int id = Integer.parseInt(columnValue2) + 1;
        String quer = "insert into  mydatabase1.tbllogin values ("+ id +","+"'"+ txtName.getText()+
                "'"+ ","+"'" + txtSurname.getText() + "'" +"," + "'"+ txtEmail.getText()+ "'"+"," + "'" +txtPassword.getText() + "'" +")";
        id++;


        stmt.execute(quer);
        txtName.clear();
        txtSurname.clear();
        txtEmail.clear();
        txtPassword.clear();
        JOptionPane.showMessageDialog(null, "You are registered");

    }
    @FXML
    void onBack(ActionEvent event) throws IOException {
        Parent secondRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene sceneSecond = new Scene(secondRoot);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneSecond);
        window.show();


    }

}
