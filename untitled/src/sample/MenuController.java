package sample;

import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MenuController {

    @FXML public Pane paneMain;
    @FXML public ImageView rollButton;
    public Pane rollPane;
    public TextField inField;
    @FXML private ImageView iView;
    @FXML private Pane paneMenu;
    @FXML private ImageView iView1;
    @FXML private Pane saladPane;
    @FXML private Pane drinkPane;
    @FXML private Pane dessertPane;
    @FXML public ImageView img2;
    @FXML public ImageView img3;
    @FXML public ImageView img4;
    @FXML public ImageView img5;
    @FXML public ImageView img6;
    @FXML public ImageView img1;
    @FXML private Button backOrder;
    @FXML private TextArea txtArea;
    @FXML private Button btn;
    @FXML private Pane orderPane;
    @FXML private ImageView roll1;
    @FXML private ImageView roll2;
    @FXML private ImageView roll3;
    @FXML private ImageView roll4;
    @FXML private ImageView roll5;
    @FXML private ImageView roll6;
    @FXML private ImageView salad1;
    @FXML private ImageView salad2;
    @FXML private ImageView salad3;
    @FXML private ImageView salad4;
    @FXML private ImageView drink1;
    @FXML private ImageView drink2;
    @FXML private ImageView drink3;
    @FXML private ImageView dessert1;
    @FXML private ImageView dessert2;
    @FXML private ImageView dessert3;

    private int total ;

    public MenuController()  {

    }
    public void myFunction(String text){
        String myName = text;

    }

    @FXML
    void onBackToLogin(ActionEvent event) throws IOException {
        Parent secondRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene sceneSecond = new Scene(secondRoot);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(sceneSecond);
        window.show();

    }

    public void ramenMenu(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            rollPane.setVisible(false);
            saladPane.setVisible(false);
            drinkPane.setVisible(false);
            dessertPane.setVisible(false);
            orderPane.setVisible(false);
            paneMenu.setVisible(true);

        }
    }

    public void rollsMenu(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            paneMenu.setVisible(false);
            saladPane.setVisible(false);
            drinkPane.setVisible(false);
            dessertPane.setVisible(false);
            orderPane.setVisible(false);
            rollPane.setVisible(true);

        }
    }

    public void saladMenu(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            paneMenu.setVisible(false);
            rollPane.setVisible(false);
            drinkPane.setVisible(false);
            dessertPane.setVisible(false);
            orderPane.setVisible(false);
            saladPane.setVisible(true);
        }
    }

    public void drinkMenu(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            paneMenu.setVisible(false);
            rollPane.setVisible(false);
            saladPane.setVisible(false);
            dessertPane.setVisible(false);
            orderPane.setVisible(false);
            drinkPane.setVisible(true);
        }
    }

    public void dessertMenu(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            paneMenu.setVisible(false);
            rollPane.setVisible(false);
            saladPane.setVisible(false);
            drinkPane.setVisible(false);
            orderPane.setVisible(false);
            dessertPane.setVisible(true);
        }

    }


    public void onMyOrder(MouseEvent mouseEvent) {
        if (mouseEvent == null) {
            System.out.println("Boooooo");
        } else {
            rollPane.setVisible(false);
            saladPane.setVisible(false);
            drinkPane.setVisible(false);
            dessertPane.setVisible(false);
            paneMenu.setVisible(false);
            orderPane.setVisible(true);




        }
    }
    public int index(){
        int index;
        String test = txtArea.getText();
        String[] area = txtArea.getText().split("\\n");
        if (test == null || test.length() == 0){
            index = 1;
        }else{
            index = area.length+1;
        }

        return index;
    }
    public void minusClick(ActionEvent actionEvent) {
        String[] a = txtArea.getText().split("\\n");
        List<String> list = new ArrayList<>(Arrays.asList(a));
        int len = list.size();
        String test ;
        int num = 0;
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i<len;i++){
            test = a[i].substring(0,2);
            test = test.strip();
            max.add(Integer.parseInt(String.valueOf(test)));
            String number = test.strip();
            if (number.equals(inField.getText())) {
                num = i;
            }
        }
        if (Collections.max(max) < Integer.parseInt(inField.getText())){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("ERROR");
            errorAlert.setContentText("TOO Big ");
            errorAlert.showAndWait();


        }else {
            String remove = list.get(num);//string to remove
            String b = remove.substring(remove.length()-7,remove.length()-3);
            b = b.trim();
            int bib = Integer.parseInt(b);
            if(bib == 250){
                total -= Integer.parseInt(b);
            }else if (bib == 180){
                total -= Integer.parseInt(b);
            }else if (bib == 200){
                total -= Integer.parseInt(b);
            }else if (bib == 150){
                total -= Integer.parseInt(b);
            }else if (bib == 230){
                total -= Integer.parseInt(b);
            }else if (bib == 280){
                total -= Integer.parseInt(b);
            }else if (bib == 330){
                total -= Integer.parseInt(b);
            }else if (bib == 290){
                total -= Integer.parseInt(b);
            }else if (bib == 350){
                total -= Integer.parseInt(b);
            }else if (bib == 190){
                total -= Integer.parseInt(b);
            }else if (bib == 240){
                total -= Integer.parseInt(b);
            }else if (bib == 210){
                total -= Integer.parseInt(b);
            }else if (bib == 120){
                total -= Integer.parseInt(b);
            }else if (bib == 170){
                total -= Integer.parseInt(b);
            }else if (bib == 45){
                total -= Integer.parseInt(b);
            }else if (bib == 80){
                total -= Integer.parseInt(b);
            }else if (bib == 90){
                total -= Integer.parseInt(b);
            }else if (bib == 110){
                total -= Integer.parseInt(b);
            }
            list.remove(remove);
            a = list.toArray(new String[0]);
            int lenght = list.size();
            txtArea.clear();
            String s;
            for (int j = 0; j < lenght; j++) {
                s = a[j];
                txtArea.appendText(s + "\n");
            }
        }



    }

    public void plusClick(ActionEvent actionEvent) {
        String[] a = txtArea.getText().split("\\n");
        List<String> list = new ArrayList<>(Arrays.asList(a));
        int len = list.size();
        String test ;
        int num = 0;
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i<len;i++){
            test = a[i].substring(0,2);
            test = test.strip();
            max.add(Integer.parseInt(String.valueOf(test)));
            String number = test.strip();
            System.out.println("My" + number);
            if (number.equals(inField.getText())) {
                num = i;
            }
        }
        if (Collections.max(max) < Integer.parseInt(inField.getText())){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("ERROR");
            errorAlert.setContentText("TOO Big ");
            errorAlert.showAndWait();


        }else {
            String remove = list.get(num);//string to remove
            String b = remove.substring(remove.length()-7,remove.length()-3);
            b = b.trim();
            int bib = Integer.parseInt(b);
            if(bib == 250){
                total += Integer.parseInt(b);
            }else if (bib == 180){
                total += Integer.parseInt(b);
            }else if (bib == 200){
                total += Integer.parseInt(b);
            }else if (bib == 150){
                total += Integer.parseInt(b);
            }else if (bib == 230){
                total += Integer.parseInt(b);
            }else if (bib == 280){
                total += Integer.parseInt(b);
            }else if (bib == 330){
                total += Integer.parseInt(b);
            }else if (bib == 290){
                total += Integer.parseInt(b);
            }else if (bib == 350){
                total += Integer.parseInt(b);
            }else if (bib == 190){
                total += Integer.parseInt(b);
            }else if (bib == 240){
                total += Integer.parseInt(b);
            }else if (bib == 210){
                total += Integer.parseInt(b);
            }else if (bib == 120){
                total += Integer.parseInt(b);
            }else if (bib == 170){
                total += Integer.parseInt(b);
            }else if (bib == 45){
                total += Integer.parseInt(b);
            }else if (bib == 80){
                total += Integer.parseInt(b);
            }else if (bib == 90){
                total += Integer.parseInt(b);
            }else if (bib == 110){

                total += Integer.parseInt(b);
            }
            list.add(remove);
            a = list.toArray(new String[0]);
            int lenght = list.size();
            txtArea.clear();
            String s;
            for (int j = 0; j < lenght; j++) {
                s = a[j];
                txtArea.appendText(s + "\n");
            }
        }

    }

    public void ramenPressed(MouseEvent mouseEvent) {
        total += Integer.parseInt(img1.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img1.getAccessibleText());
            b += img1.getAccessibleHelp();
            a += img1.getAccessibleText();
            txtArea.appendText(index()+" . "+b + " : "+ a + " som"+"\n");


        }
    }

    public void ramenChickenPressed(MouseEvent mouseEvent) {
        total += Integer.parseInt(img2.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img2.getAccessibleText());
            b += img2.getAccessibleHelp();
            a += img2.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");


        }
    }

    public void vegetablesRamen(MouseEvent mouseEvent) {
        total += Integer.parseInt(img3.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img3.getAccessibleText());
            b += img3.getAccessibleHelp();
            a += img3.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");


        }
    }

    public void friedRamen(MouseEvent mouseEvent) {
        total += Integer.parseInt(img4.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img4.getAccessibleText());
            b += img4.getAccessibleHelp();
            a += img4.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");


        }
    }

    public void milkyRamen(MouseEvent mouseEvent) {
        total += Integer.parseInt(img5.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img5.getAccessibleText());
            b += img5.getAccessibleHelp();
            a += img5.getAccessibleText();

            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");


        }
    }


    public void shrimpRamen(MouseEvent mouseEvent) {
        total += Integer.parseInt(img6.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(img6.getAccessibleText());
            b += img6.getAccessibleHelp();
            a += img6.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }





    public void philadelphiaClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll1.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll1.getAccessibleText());
            b += roll1.getAccessibleHelp();
            a += roll1.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void canadaClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll2.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll2.getAccessibleText());
            b += roll2.getAccessibleHelp();
            a += roll2.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void friedRollsClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll3.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll3.getAccessibleText());
            b += roll3.getAccessibleHelp();
            a += roll3.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void sakeMakiClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll4.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll4.getAccessibleText());
            b += roll4.getAccessibleHelp();
            a += roll4.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void nigiriSushiClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll5.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll5.getAccessibleText());
            b += roll5.getAccessibleHelp();
            a += roll5.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void gunkanSushiClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(roll6.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null) {
            throw new IllegalArgumentException("Num не должен быть null");
        } else {
            System.out.println("Work");
            System.out.println(roll6.getAccessibleText());
            b += roll6.getAccessibleHelp();
            a += roll6.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : " + a + " som" + "\n");

        }
    }

    public void seaweedClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(salad1.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(salad1.getAccessibleText());
            b += salad1.getAccessibleHelp();
            a += salad1.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void kinpiraClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(salad2.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(salad2.getAccessibleText());
            b += salad2.getAccessibleHelp();
            a += salad2.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void cucumberClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(salad3.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(salad3.getAccessibleText());
            b += salad3.getAccessibleHelp();
            a += salad3.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void classicClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(salad4.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(salad4.getAccessibleText());
            b += salad4.getAccessibleHelp();
            a += salad4.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void waterClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(drink1.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(drink1.getAccessibleText());
            b += drink1.getAccessibleHelp();
            a += drink1.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void teaClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(drink2.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(drink2.getAccessibleText());
            b += drink2.getAccessibleHelp();
            a += drink2.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void sakeClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(drink3.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(drink3.getAccessibleText());
            b += drink3.getAccessibleHelp();
            a += drink3.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void pastryClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(dessert1.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(dessert1.getAccessibleText());
            b += dessert1.getAccessibleHelp();
            a += dessert1.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void cakeClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(dessert2.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(dessert2.getAccessibleText());
            b += dessert2.getAccessibleHelp();
            a += dessert2.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void mociClicked(MouseEvent mouseEvent) {
        total += Integer.parseInt(dessert3.getAccessibleText());
        String a = "";
        String b = "";
        if (mouseEvent == null){
            throw new IllegalArgumentException("Num не должен быть null");
        }else{
            System.out.println("Work");
            System.out.println(dessert3.getAccessibleText());
            b += dessert3.getAccessibleHelp();
            a += dessert3.getAccessibleText();
            txtArea.appendText(index()+" . " + b + " : "+ a + " som"+ "\n");
        }
    }

    public void amountCalculate(ActionEvent actionEvent){
        JOptionPane.showMessageDialog(null, "Total : " + total + " som");

    }

    public void makeOrder(ActionEvent actionEvent)  throws IOException  {
        File f = new File("order.txt");
        FileWriter file = new FileWriter(f);
        file.write(txtArea.getText());
        file.write("--------------------------------------------------\n");
        file.write("Total :" + total);
        file.flush();
        file.close();
        txtArea.clear();
        JOptionPane.showMessageDialog(null, "Your order has been accepted.\n" +
                "It will be ready in 30 minutes.\n"+
                        "Your check : "+total);
    }


}
