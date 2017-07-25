package sample;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-21.
 */
public class DatabaseCustomerDAO implements IDao<Customer> {
    private DatabaseServer server;

    public DatabaseCustomerDAO(DatabaseServer server) {
        this.server = server;
    }

    public void connect() throws SQLException {
        server.connect();
    }

    public Customer getCustomerById(int id) {
        Statement statement = null;
        Customer customer = null;
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers where id = " +
                    id + ";");
            while (resultSet.next()) {
                String name = resultSet.getString(resultSet.findColumn("name"));
                String address = resultSet.getString(resultSet.findColumn("address"));
                int phoneNo = resultSet.getInt(resultSet.findColumn("phone_no"));
                customer = new Customer(id, name, phoneNo, address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return customer;
    }
    public int getCustomerIdByName(Customer customer){
        Statement statement = null;
        int id = 0;
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers where name = \"" +
                customer.getName() + "\";");
            while (resultSet.next()) {
                id = resultSet.getInt(resultSet.findColumn("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

       return id;
    }

    public List<Customer> get() {
        Statement statement = null;
        List<Customer> list = new ArrayList<Customer>();
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers left join surveys on " +
                    "surveys.id = customers.id;");
            while (resultSet.next()) {
                int id = resultSet.getInt(resultSet.findColumn("id"));
                String name = resultSet.getString(resultSet.findColumn("name"));
                int phone= resultSet.getInt(resultSet.findColumn("phone_no"));
                String address = resultSet.getString(resultSet.findColumn("address"));
                String q1 = resultSet.getString(resultSet.findColumn("question1"));
                String q2 = resultSet.getString(resultSet.findColumn("question2"));
                String q3 = resultSet.getString(resultSet.findColumn("question3"));
                Customer customer = new Customer(id, name, phone, address);
                if(q1!= null){
                    customer.setSurvey(new Survey(customer.getId(),q1,q2,q3));
                }
                list.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public void addSurvey(Survey survey){
        Statement statement1 = null;
        try {
            this.connect();


                statement1.executeUpdate("insert into surveys (id, question1, question2, question3) value" +
                        " (" + survey.getId() + " , \"" + survey.getQuestion1()
                        + "\", \"" + survey.getQuestion2() + "\", \"" +
                        survey.getQuestion3() + "\" );");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public int add(Customer customer) {
        Statement statement1 = null;
        PreparedStatement preparedStatement = null;
        String query = "insert into customers (name, phone_no, address) value" +
                " (\"" + customer.getName() +
                "\",\"" + customer.getPhoneNo() +
                "\",\"" + customer.getAddress() + "\");";
        int result = 0 ;
        try {
            this.connect();
            preparedStatement = server.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            result = preparedStatement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                try(ResultSet generatedKeys =preparedStatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        result = generatedKeys.getInt(1);
                    }
                }


            if (customer.getSurvey() != null){
                statement1 = server.returnStatement();
                statement1.executeUpdate("insert into surveys (id, question1, question2, question3) value" +
                        " (" + result + " , \"" +customer.getSurvey().getQuestion1()
                        + "\", \"" + customer.getSurvey().getQuestion2() + "\", \"" +
                        customer.getSurvey().getQuestion3() + "\" );");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void update(Customer customer) {
        Statement statement = null;
        try {
            statement = server.returnStatement();

            statement.executeUpdate("update customers set name = \"" + customer.getName() +
                    "\", phone_no = \"" + customer.getPhoneNo() + "\" , address = \"" + customer.getAddress()
                    + " where id = " + customer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void delete(Customer customer) {
        Statement statement1 = null;
        try {
            statement1 = server.returnStatement();
            if(customer.getSurvey() != null){
                statement1.executeUpdate("delete from surveys where id = " + customer.getId() + ";" );
            }

            statement1.executeUpdate("delete from customers where id = " + customer.getId() + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void close() {
        server.close();
    }

}
