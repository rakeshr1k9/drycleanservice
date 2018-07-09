package in.ogmatech.techstile.drycleanservice.wrapper;

import in.ogmatech.techstile.drycleanservice.model.*;

public class ItemWrapper extends Item {
    private Order order;
    private ItemType itemType;
    private ItemStatus itemStatus;
    private Branch branch;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
