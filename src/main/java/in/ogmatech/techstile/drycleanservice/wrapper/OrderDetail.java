package in.ogmatech.techstile.drycleanservice.wrapper;

import in.ogmatech.techstile.drycleanservice.model.Branch;
import in.ogmatech.techstile.drycleanservice.model.Customer;
import in.ogmatech.techstile.drycleanservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetail {

    private OrderWrapper orderWrapper;
    private List<ItemWrapper> itemWrappers;

}
