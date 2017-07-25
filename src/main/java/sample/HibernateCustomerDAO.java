package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by RENT on 2017-07-25.
 */
public class HibernateCustomerDAO implements IDao<Customer> {
    private SessionFactory factory;

    public HibernateCustomerDAO(String cfg){
        Configuration configuration = new Configuration();
        configuration.configure(Main.class.getClassLoader().getResource(cfg));
        factory = configuration.buildSessionFactory();
    }
    @Override
    public List<Customer> get() {
        Session session = factory.openSession();

        List<Customer> users = (List<Customer>)session.createQuery("from Customer").list();

        session.close();

        return users;
    }

    @Override
    public int add(Customer customer) {
        return 0;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
