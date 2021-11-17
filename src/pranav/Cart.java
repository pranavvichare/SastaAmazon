package pranav;

import java.util.ArrayList;

public class Cart {
    private String type;
    private ArrayList<Items> itemsArrayList;

    Cart(){
        itemsArrayList = new ArrayList<>();
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Items> getItemsArrayList() {
        return itemsArrayList;
    }

    public void setItemsInArrayList(Items items) {
        this.itemsArrayList.add(items);
    }
}