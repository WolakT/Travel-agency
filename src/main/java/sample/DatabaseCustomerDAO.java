package sample;



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

    public List<Customer> get() {
        Statement statement = null;
        List<Customer> list = new ArrayList<Customer>();
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from customers;");
            while (resultSet.next()) {
                int id = resultSet.getInt(resultSet.findColumn("id"));
                String name = resultSet.getString(resultSet.findColumn("name"));
                int phone= resultSet.getInt(resultSet.findColumn("phone_no"));
                String address = resultSet.getString(resultSet.findColumn("address"));

                list.add(new Customer(id, name, phone, address ));
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

    public void add(Customer customer) {
        Statement statement1 = null;
        try {
            this.connect();
            statement1 = server.returnStatement();

            statement1.executeUpdate("insert into customers (name, phone_no, address) value" +
                    " (\"" + customer.getName() +
                    "\",\"" + customer.getPhoneNo() +
                    "\",\"" + customer.getAddress() + "\");");


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

            statement1.executeUpdate("delete from customers where id = " + customer.getId());
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
