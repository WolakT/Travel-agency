package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main  {
//extends Application
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {


        DatabaseServer server = new DatabaseServer("localhost", "travelagencydb", "travelagent", "pass123");
        DatabaseCustomerDAO customerDao = new DatabaseCustomerDAO(server);
        List<Customer> lst =  customerDao.get();
        for (Customer customer: lst ) {
            System.out.println(customer);
        }

        Customer customer1 = new Customer(0, "Natasza Fabianska", 244125332, "Rzeszów");
//        customer1.setSurvey(new Survey(customer1.getId(), "no", "yes", "no"));
        customerDao.add(customer1);

        lst =  customerDao.get();
        for (Customer customer: lst ) {
            System.out.println(customer);
        }

//        Customer deleteCustomer = lst.get(8);
//        customerDao.delete(deleteCustomer);


//        server.close();

        customerDao.close();
        //launch(args);
    }
}
