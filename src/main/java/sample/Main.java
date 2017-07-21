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


        DatabaseServer server = new DatabaseServer("localhost", "travelagencydb", "travelAgent", "pass123");
        DatabaseCustomerDAO customerDao = new DatabaseCustomerDAO(server);
        List<Customer> lst =  customerDao.get();
        for (Customer customer: lst ) {
            System.out.println(customer);
        }
        customerDao.add(new Customer(0, "Jozef Zieba", 534541423, "krakow"));
        lst = customerDao.get();
        for (Customer customer: lst ) {
            System.out.println(customer);
        }
        DatabaseSurveysDAO  surveysDAO = new DatabaseSurveysDAO(server);
        List<Survey> surveyList = surveysDAO.get();

        for (Survey survey : surveyList) {
            System.out.println(survey);
        }
        server.close();
        surveysDAO.close();
        customerDao.close();
        //launch(args);
    }
}
