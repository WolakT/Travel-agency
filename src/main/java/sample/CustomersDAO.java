package sample;

import java.util.List;

/**
 * Created by RENT on 2017-07-21.
 */
public interface CustomersDAO {

    List<Customer> get();
    void add(Customer customer);
    void update(Customer customer);
    void delete (Customer customer);
}
