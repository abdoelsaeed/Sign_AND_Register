package com.example.sign_in_up;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Button cancel;

    @FXML
    private PasswordField password;

    @FXML
    private Label result;

    @FXML
    private Button signin;

    @FXML
    private TextField user;

    @FXML
    void cancel(ActionEvent event) {
        Stage stage=(Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void signin(ActionEvent event) {
       valid();
        if(password.getText().isBlank()==false&&user.getText().isBlank()==false){
            valid();
       }
       else{result.setText("Please, Enter User name and Password");}

}
void valid(){

     connection con=new connection();
    Connection con1=con.getconnection();
    String q="SELECT COUNT(1) FROM login WHERE username='"+user.getText()+"'AND password='"+password.getText()+"';";
 try {
     Statement s=con1.createStatement();
     ResultSet r=s.executeQuery(q);
     while (r.next()){
         if(r.getInt(1)==1){
             result.setText("WELCOME");
         }
         else{result.setText("failed");
            }
     }
 }catch (SQLException e){
     e.printStackTrace();
 }
}
    @FXML
    void register(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}



