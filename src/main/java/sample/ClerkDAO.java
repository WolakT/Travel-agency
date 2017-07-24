package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2017-07-24.
 */
public class ClerkDAO implements IDao<Clerk> {
    private DatabaseServer server;

    public ClerkDAO(DatabaseServer server) {
        this.server = server;
    }
    public void connect() throws SQLException {
        server.connect();
    }

    public Clerk getClerkById(int id){

        Statement statement = null;
        Clerk clerk= null;
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from clerks where id = " +
                    id + ";");
            while (resultSet.next()) {
                String name = resultSet.getString(resultSet.findColumn("name"));
                String jobTitle = resultSet.getString(resultSet.findColumn("job_title"));
                Date hireDate = resultSet.getDate(resultSet.findColumn("hire_date"));
                clerk = new Clerk(id, name, jobTitle, hireDate);
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
        return clerk;
    }

    public List<Clerk> get() {
        List<Clerk> list = new ArrayList<Clerk>();
        Statement statement = null;

        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from clerks;");
            while (resultSet.next()) {
                String name = resultSet.getString(resultSet.findColumn("name"));
                String jobTitle = resultSet.getString(resultSet.findColumn("job_title"));
                Date hireDate = resultSet.getDate(resultSet.findColumn("hire_date"));
                list.add(new Clerk(0, name, jobTitle, hireDate));
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



    public int add(Clerk clerk) {
    return 0;
    }

    public void update(Clerk clerk) {

    }

    public void delete(Clerk clerk) {

    }
}
