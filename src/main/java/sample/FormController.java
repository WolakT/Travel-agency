package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.beans.EventHandler;
import java.sql.SQLException;

/**
 * Created by RENT on 2017-07-20.
 */
public class FormController {
    @FXML private Button buttonAdd;
    @FXML private Text actiontarget;
    @FXML private TextField customerName;
    @FXML private TextField phoneNo;
    @FXML private TextField q1;
    @FXML private TextField q2;
    @FXML private TextField q3;
    @FXML private TextField address;


    public void get(ActionEvent e) {


        DatabaseCustomerDAO customerDAO = new DatabaseCustomerDAO(new DatabaseServer("localhost",
                "travelagencydb", "travelagent", "pass123"));
        try {
            customerDAO.connect();
            customerDAO.add(new Customer(0, customerName.getText(), Integer.parseInt(phoneNo.getText()),
                    address.getText()));
            System.out.println(customerName.getText());
            actiontarget.setText("Added to database");
        } catch (SQLException e1) {
            e1.printStackTrace();
            actiontarget.setText(e1.getMessage());
        } catch (Exception ex ){
            actiontarget.setText(ex.getMessage());
        }

    }
}
