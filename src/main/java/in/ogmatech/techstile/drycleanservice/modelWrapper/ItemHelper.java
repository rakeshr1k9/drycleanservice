package in.ogmatech.techstile.drycleanservice.modelWrapper;

import in.ogmatech.techstile.drycleanservice.model.Item;
import in.ogmatech.techstile.drycleanservice.model.ItemServiceType;
import in.ogmatech.techstile.drycleanservice.model.ServiceType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemHelper implements Serializable{

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private List<ItemServiceType> itemServiceTypes;

    public List<ItemServiceType> getItemServiceTypes() {
        return itemServiceTypes;
    }

    public void setItemServiceTypes(List<ItemServiceType> itemServiceTypes) {
        this.itemServiceTypes = itemServiceTypes;
    }
}
