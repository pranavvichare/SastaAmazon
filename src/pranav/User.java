package pranav;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String currentStore;
    private HashMap<String, ArrayList<Items>> cartHashMap;

    public User() {
        cartHashMap = new HashMap<>();
    }

    public HashMap<String,ArrayList<Items>> getCart() {
        return cartHashMap;
    }

    public String getCurrentStore() {
        return this.currentStore;
    }

    public void setCurrentStore(String currentStore) {
        this.currentStore = currentStore;
    }
}
