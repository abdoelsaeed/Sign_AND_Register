package com.example.sign_in_up;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {

    @FXML
    private Button close;

    @FXML
    private PasswordField cpassword;

    @FXML
    private TextField first;
    @FXML
    private Label result;

    @FXML
    private TextField last;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private TextField user;

    @FXML
    void close(ActionEvent event) {
        Stage stage=(Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void register(ActionEvent event) {
if(((password.getText()).equals((cpassword.getText())))&&(first.getText().isBlank()==false||last.getText().isBlank()==false||user.getText().isBlank()==false||password.getText().isBlank()==false||cpassword.getText().isBlank()==false)){
    r();
    first.setText("");
    last.setText("");
    user.setText("");
    password.setText("");
    cpassword.setText("");
    result.setText("DONE");
}
else if(!(password.getText()).equals((cpassword.getText()))){
    result.setText("Password not equal Confirm Password");
}
else if(first.getText().isBlank()==true||last.getText().isBlank()==true||user.getText().isBlank()==true||password.getText().isBlank()==true||cpassword.getText().isBlank()==true){
    result.setText("Please Enter ALL Data");
    }
    }
    public void r(){

            connection con = new connection();
            Connection c = con.getconnection();
            String q = "INSERT INTO login(firstname,lastname,username,password)VALUES('" + first.getText() + "','" + last.getText() + "','" + user.getText() + "','" + password.getText() + "');";
            try {
                Statement s = c.createStatement();
                s.execute(q);

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

}