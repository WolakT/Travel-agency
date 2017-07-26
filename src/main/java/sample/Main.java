package sample;

import com.mysql.jdbc.Driver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application {
//extends Application
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        Scene scene = new Scene(root, 350, 375);

        stage.setTitle("Travel Agency");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {


        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        HibernateCustomerDAO hibernateCustomerDAO =new HibernateCustomerDAO("hibernate/hibernate.cfg.xml");
        List<Customer> customers = hibernateCustomerDAO.get();
        System.out.println("----------using hibernate annotations-------------");
        customers.forEach((customer) -> {
            System.out.println(customer.toString());
        });

        int num =hibernateCustomerDAO.add(new Customer(0,"Hibernate annotations", 234453234, "krakow"));
        System.out.println("End of hibernate annotations");










        launch(args);

        DatabaseServer server = new DatabaseServer("localhost", "travelagencydb", "travelAgent", "pass123");
        DatabaseCustomerDAO customerDao = new DatabaseCustomerDAO(server);
//        List<Customer> lst =  customerDao.get();
//        for (Customer customer: lst ) {
//            System.out.println(customer);
//        }

//        Customer customer1 = new Customer(0, "Natasza Fabianska", 244125332, "Rzeszów");
//        customer1.setSurvey(new Survey(customer1.getId(), "no", "yes", "no"));
//        int id = customerDao.add(customer1);
//        System.out.println("Customers id is " + id);
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

        SoldTripsDAO tripsDAO = new SoldTripsDAO(server);
        List<SoldTrips> list = new ArrayList<SoldTrips>();
        list = tripsDAO.get();
        for (SoldTrips trip : list) {
            System.out.println(trip);
        }

    }
}
