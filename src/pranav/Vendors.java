package pranav;

import java.util.ArrayList;
import java.util.HashMap;

public class Vendors {

    private String logo;
    private String slogan;
    private String shopName;
    private HashMap<String,Items> itemsHashMap;

    public Vendors(String logo, String slogan, String shopName, HashMap<String,Items> arrayList) {
        this.logo = logo;
        this.slogan = slogan;
        this.shopName = shopName;
        this.itemsHashMap = arrayList;
    }

    public String getSlogan() {
        return slogan;
    }

    public HashMap<String,Items> getItemsHashMap() {
        return itemsHashMap;
    }

}
