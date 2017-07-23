package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application  {
//extends Application
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        Scene scene = new Scene(root, 350, 375);

        stage.setTitle("Travel Agency");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);

//        DatabaseServer server = new DatabaseServer("localhost", "travelagencydb", "travelagent", "pass123");
//        DatabaseCustomerDAO customerDao = new DatabaseCustomerDAO(server);
//        List<Customer> lst =  customerDao.get();
//        for (Customer customer: lst ) {
//            System.out.println(customer);
//        }

//        Customer customer1 = new Customer(0, "Natasza Fabianska", 244125332, "Rzeszów");
////        customer1.setSurvey(new Survey(customer1.getId(), "no", "yes", "no"));
//        customerDao.add(customer1);

//        lst =  customerDao.get();
//        for (Customer customer: lst ) {
//            System.out.println(customer);
////            if(customer.getId() == 15) {
////                System.out.println("delete mariola");
////                customerDao.delete(customer);
////            }
//
//        }

//        Customer deleteCustomer = lst.get(8);

//        server.close();
//
//        customerDao.close();

    }
}
