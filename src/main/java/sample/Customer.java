package sample;

/**
 * Created by RENT on 2017-07-21.
 */
public class Customer {
    private int id;
    private String name;
    private int phoneNo;
    private String address;

    public Customer(int id, String name, int phoneNo, String address) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                ", address='" + address + '\'' +
                '}';
    }
}
