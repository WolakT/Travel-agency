package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.beans.EventHandler;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by RENT on 2017-07-20.
 */
public class FormController implements Initializable {
    @FXML private Button buttonAdd;
    @FXML private Text actiontarget;
    @FXML private TextField customerName;
    @FXML private TextField phoneNo;
    @FXML private ComboBox q1;
    @FXML private ComboBox q2;
    @FXML private ComboBox q3;
    @FXML private TextField address;


    public void get(ActionEvent e) {


        DatabaseCustomerDAO customerDAO = new DatabaseCustomerDAO(new DatabaseServer("localhost",
                "travelagencydb", "travelAgent", "pass123"));
        try {
            customerDAO.connect();
            Customer customer = new Customer(0, customerName.getText(), Integer.parseInt(phoneNo.getText()),
                    address.getText());
            if(q1.getValue() != null){
                customer.setSurvey(new Survey(0 ,q1.getValue().toString(),q2.getValue().toString()
                        ,q3.getValue().toString()));
            }
            int id = customerDAO.add(customer);

            System.out.println(customerName.getText());
            actiontarget.setText("Added to database");
        } catch (SQLException e1) {
            e1.printStackTrace();
            actiontarget.setText(e1.getMessage());
        } catch (Exception ex ){
            actiontarget.setText(ex.getMessage());
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = FXCollections.observableArrayList("Yes", "No");
        q1.setItems(options);
        q2.setItems(options);
        q3.setItems(options);

    }
}
