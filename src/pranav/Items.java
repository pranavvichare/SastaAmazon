package pranav;

public class Items {

    private String itemName;
    private int quntity;
    private int itemPrice;

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuntity() {
        return quntity;
    }

    public Items(String itemName, int quntity, int itemPrice) {
        this.itemName = itemName;
        this.quntity = quntity;
        this.itemPrice = itemPrice;
    }

    public void setQuntity(int quntity){
        this.quntity -= quntity;
    }
}
