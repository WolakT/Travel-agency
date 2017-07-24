package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomcio on 2017-07-23.
 */
public class SoldTripsDAO implements IDao<SoldTrips> {
    private DatabaseServer server;
    private ClerkDAO clerkDAO;
    private DatabaseCustomerDAO customerDAO;

    public SoldTripsDAO(DatabaseServer server) {
        this.server = server;
        this.clerkDAO =  new ClerkDAO(server);
        this.customerDAO = new DatabaseCustomerDAO(server);
    }

    public void connect() throws SQLException {
        server.connect();
    }


    public List<SoldTrips> get() {
        Statement statement = null;
        List<SoldTrips> list = new ArrayList<SoldTrips>();
        int id = 0;
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from sold_trips;");
            while (resultSet.next()) {
                id = resultSet.getInt(resultSet.findColumn("id"));
                int idOffer = resultSet.getInt(resultSet.findColumn("id_offer"));
                int idCustomer = resultSet.getInt(resultSet.findColumn("id_customer"));
                int idClerk= resultSet.getInt(resultSet.findColumn("id_clerk"));
                int discount = resultSet.getInt(resultSet.findColumn("discount"));
                Date startDate = resultSet.getDate(resultSet.findColumn("start_date"));
                Customer customer = customerDAO.getCustomerById(idCustomer);
                Clerk clerk = clerkDAO.getClerkById(idClerk);
                ClerkDAO clerkDAO = new ClerkDAO(server);

                list.add(new SoldTrips(id, discount, startDate, customer, clerk  ));
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

    public int add(SoldTrips soldTrips) {
    return 0;
    }

    public void update(SoldTrips soldTrips) {

    }

    public void delete(SoldTrips soldTrips) {

    }
}
