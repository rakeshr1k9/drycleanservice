package in.ogmatech.techstile.drycleanservice.helperModel;

import in.ogmatech.techstile.drycleanservice.model.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class helperOrder implements Serializable {


    private Customer customer;
    private Branch branch;
    private OrderStatus orderStatus;
    private OrderType orderType;
    private List<Item> items;
    private List<Payment> payments;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
