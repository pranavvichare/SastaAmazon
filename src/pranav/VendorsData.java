package pranav;

import java.util.ArrayList;
import java.util.HashMap;

public class VendorsData {

    public static ArrayList<Vendors> getVegetableVendor() {

        ArrayList<Vendors> arrayListVendors = new ArrayList<>();
        HashMap<String,Items> itemsArrayList1 = new HashMap<>();

        Items items1 = new Items("Tomato",50,30);
        Items items2 = new Items("Onion",50,40);
        Items items3 = new Items("Potato",50,50);
        Items items4 = new Items("Gaur Beans",50,20);

        itemsArrayList1.put("Tomato",items1);
        itemsArrayList1.put("Onion",items2);
        itemsArrayList1.put("Potato", items3);
        itemsArrayList1.put("Gaur Beans", items4);
        Vendors vendors1 = new Vendors("20","A","pranav",itemsArrayList1);

        HashMap<String,Items> itemsArrayList2 = new HashMap<>();

        Items items5 = new Items("Tomato",50,40);
        Items items6 = new Items("Onion",50,50);
        Items items7 = new Items("Potato",50,20);
        Items items8 = new Items("Gaur Beans",50,30);

        itemsArrayList2.put("Tomato",items5);
        itemsArrayList2.put("Onion",items6);
        itemsArrayList2.put("Potato",items7);
        itemsArrayList2.put("Gaur Beans",items8);
        Vendors vendors2 = new Vendors("21","B","ganesh",itemsArrayList2);

        HashMap<String,Items> itemsArrayList3 = new HashMap<>();

        Items items9 = new Items("Tomato",50,50);
        Items items10 = new Items("Onion",50,20);
        Items items11 = new Items("Potato",50,30);
        Items items12 = new Items("Gaur Beans",50,40);

        itemsArrayList3.put("Tomato",items9);
        itemsArrayList3.put("Onion",items10);
        itemsArrayList3.put("Potato",items11);
        itemsArrayList3.put("Gaur Beans",items12);
        Vendors vendors3 = new Vendors("22","C","pranav_ganesh",itemsArrayList3);

        arrayListVendors.add(vendors1);
        arrayListVendors.add(vendors2);
        arrayListVendors.add(vendors3);

        return arrayListVendors;
    }

    public static ArrayList<Vendors> getFruitsVendor(){

        ArrayList<Vendors> arrayListVendors = new ArrayList<>();
        HashMap<String,Items> itemsArrayList1 = new HashMap<>();

        Items items1 = new Items("Apple",50,30);
        Items items2 = new Items("Banana",50,40);
        Items items3 = new Items("Orange",50,50);
        Items items4 = new Items("Mango",50,20);

        itemsArrayList1.put("Apple",items1);
        itemsArrayList1.put("Banana",items2);
        itemsArrayList1.put("Orange",items3);
        itemsArrayList1.put("Mango",items4);
        Vendors vendors1 = new Vendors("20","A","Fruit_Store",itemsArrayList1);

        arrayListVendors.add(vendors1);

        return arrayListVendors;
    }

    public static ArrayList<Vendors> getGroceryVendor(){

        ArrayList<Vendors> arrayListVendors = new ArrayList<>();
        HashMap<String,Items> itemsArrayList1 = new HashMap<>();

        Items items1 = new Items("Soap",20,30);
        Items items2 = new Items("Shampoo",20,40);
        Items items3 = new Items("Oil",20,50);
        Items items4 = new Items("Powder",20,20);

        itemsArrayList1.put("Soap",items1);
        itemsArrayList1.put("Shampoo",items2);
        itemsArrayList1.put("Oil",items3);
        itemsArrayList1.put("Powder",items4);
        Vendors vendors1 = new Vendors("20","A","Grocery_Store",itemsArrayList1);


        arrayListVendors.add(vendors1);

        return arrayListVendors;
    }
}
