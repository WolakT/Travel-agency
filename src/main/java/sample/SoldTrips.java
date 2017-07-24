package sample;

import java.util.Date;

/**
 * Created by Tomcio on 2017-07-23.
 */
public class SoldTrips {
    private int id;
    private int discount;
    private Date startDate;
    private Clerk clerk;
    private Customer customer;
    private Offer offer;

    public SoldTrips(int id, int discount, Date startDate, Customer customer, Clerk clerk) {
        this.id = id;
        this.discount = discount;
        this.startDate = startDate;
        this.clerk = clerk;
        this.customer = customer;
//        this.offer = offer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "SoldTrips{" +
                "id=" + id +
                ", discount=" + discount +
                ", startDate=" + startDate +

                ", customer=" + customer +
                ", clerk =" + clerk +
                '}';
    }
}
