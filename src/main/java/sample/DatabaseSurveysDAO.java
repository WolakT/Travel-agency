package sample;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-21.
 */
public class DatabaseSurveysDAO implements IDao<Survey> {
    private DatabaseServer server;

    public DatabaseSurveysDAO(DatabaseServer server){
        this.server = server;
    }
    public void connect() throws SQLException {
        server.connect();
    }
    public void add(Survey survey) {

    }

    public List<Survey> get() {
        Statement statement = null;
        List<Survey> list = new ArrayList<Survey>();
        try {
            this.connect();
            statement = server.returnStatement();
            ResultSet resultSet = statement.executeQuery("select * from surveys;");
            while (resultSet.next()) {
                int id = resultSet.getInt(resultSet.findColumn("id"));
                String q1 = resultSet.getString(resultSet.findColumn("question1"));
                String q2 = resultSet.getString(resultSet.findColumn("question2"));
                String q3 = resultSet.getString(resultSet.findColumn("question3"));

                list.add(new Survey(id, q1,q2,q3 ));
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



    public void update(Survey survey) {

    }

    public void delete(Survey survey) {

    }
    public void close() {
        server.close();
    }
}
