package in.ogmatech.techstile.drycleanservice.modelWrapper;

import in.ogmatech.techstile.drycleanservice.model.*;

import java.io.Serializable;
import java.util.List;

public class ItemWrapper implements Serializable {

    public List<ItemHelper> itemHelpers;

    public List<ItemHelper> getItemHelpers() {
        return itemHelpers;
    }

    public void setItemHelpers(List<ItemHelper> itemHelpers) {
        this.itemHelpers = itemHelpers;
    }




}

