package pranav;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;


public class SastaAmazon {
    boolean isOpen;
    private String admin;
    HashMap<String,User> hashMap;
    SastaAmazon(){
        isOpen = true;
        this.admin = "admin";
        hashMap = new HashMap<>();
    }
    public static void createNewUser(SastaAmazon s, String userName) {
        User user = new User();
        if(s.hashMap.size() < 3){
            s.hashMap.put(userName,user);
            System.out.println("|   welcome " + userName + "    |");
        }else{
            System.out.println("only 3 person allowed in market please wait");
        }

    }

    public static void exitNewUser(SastaAmazon s, String userName) {
        HashMap<String,ArrayList<Items>> historyhashmap = s.hashMap.get(userName).getCart();
        int totalItem = 0;
        int totalMoney = 0;
        for (Map.Entry<String,ArrayList<Items>> entry : historyhashmap.entrySet()) {
            ArrayList<Items> value = entry.getValue();
            totalItem += value.size();
            for (int i = 0; i < value.size(); i++) {
                Items items = value.get(i);
                System.out.println("ItemName: "+items.getItemName() + "   Quantity: " + items.getQuntity()+"   Price: " +items.getItemPrice() + " ₹");
                totalMoney += items.getQuntity() * items.getItemPrice();
            }
        }
        System.out.println("totalItem: " + totalItem);
        System.out.println("totalMoney: " + totalMoney + " ₹");
        s.hashMap.remove(userName);
    }

    public String getAdmin() {
        return admin;
    }

    public static void helpMethod(){
        System.out.println("|-----------------------------------------------------------------|");
        System.out.println("|     commands:(help)....(This command shows a way to buy)        |");
        System.out.println("|         <userName> avail <V/F/G> <itemName> <quantity>          |");
        System.out.println("|         <userName> buy <V/F/G> <itemName> <quantity>            |");
        System.out.println("|                        <userName> enter                         |");
        System.out.println("|                        <userName> exit                          |");
        System.out.println("|                           show <V/F/G>                          |");
        System.out.println("|_________________________________________________________________|");
    }
    public static int availItems(String itemName,Vendors currentVendor,int quantity,SastaAmazon s,String userName,boolean flag){
        if(!s.hashMap.containsKey(userName)){
            System.out.println("|----------------------------|");
            System.out.println("|    please enter first      |");
            System.out.println("|____________________________|");
            return -1;
        }
        HashMap<String,Items> itemsHashMap = currentVendor.getItemsHashMap();
        if(itemsHashMap.containsKey(itemName)){
            if (itemsHashMap.get(itemName).getQuntity()>=quantity){
                System.out.println("|--------------------|");
                if(!flag) System.out.println("|   item available   |");
                else      System.out.println("|   item Purchased   |");
                System.out.println("|____________________|");
                return itemsHashMap.get(itemName).getItemPrice();
            }
            else if(itemsHashMap.get(itemName).getQuntity() != 0){
                System.out.println("|------------------------------------------------------|");
                System.out.println("|   item is available but this quantiy not available   |");
                System.out.println("|______________________________________________________|");
                return -1;
            }
            else {
                System.out.println("|----------------------------|");
                System.out.println("|   item is not available    |");
                System.out.println("|____________________________|");
                return -1;
            }
        }
        else{
            System.out.println("|----------------------------|");
            System.out.println("|       item not found       |");
            System.out.println("|____________________________|");
            return -1;
        }
    }


    public static void buyItems(Vendors currentVendor,SastaAmazon s,String userName,int quantity,String itemName,String type){
        int price = SastaAmazon.availItems(itemName, currentVendor,quantity,s,userName,true);
        if(price == -1){
            return ;
        }
        User user = s.hashMap.get(userName);
        String currentType = user.getCurrentStore();
        user.setCurrentStore(type);
        HashMap<String,ArrayList<Items>> cartHasMap = user.getCart();
        if(!type.equals(currentType) && cartHasMap.containsKey(currentType)){
            System.out.println("Vendor: " + currentVendor.getSlogan());
            ArrayList<Items> arrayList = cartHasMap.get(currentType);
            SastaAmazon.shopHistory(arrayList);
        }
        if(!cartHasMap.containsKey(type)) cartHasMap.put(type,new ArrayList<Items>());
        ArrayList<Items> arrayListitems = cartHasMap.get(type);
        Items items = new Items(itemName,quantity,price);
        arrayListitems.add(items);
        Items items1 = currentVendor.getItemsHashMap().get(itemName);
        items1.setQuntity(quantity);
    }

    public static void shopHistory(ArrayList<Items> arrayList){
        System.out.println("previous buy items");
        int totalMoney = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Items items = arrayList.get(i);
            totalMoney += items.getQuntity() * items.getItemPrice();
            System.out.println("ItemName: "+items.getItemName() + "   Quantity: " + items.getQuntity()+"   Price: " +items.getItemPrice() + " ₹");
        }
        System.out.println("TotalItem: " + arrayList.size());
        System.out.println("TotalBill: " + totalMoney);
    }

    public static void main(String []args) throws Exception {
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String adminName = stringTokenizer.nextToken();
            String openComman = stringTokenizer.nextToken();
            SastaAmazon sastaAmazon = new SastaAmazon();
            if(openComman.equals("open") && sastaAmazon.getAdmin().equals(adminName)){
                System.out.println("|--------------------------|");
                System.out.println("|       Market open        |");
                System.out.println("|__________________________|");
                ArrayList<Vendors> allVegetableVendors = VendorsData.getVegetableVendor();
                ArrayList<Vendors> allFruitVendors = VendorsData.getFruitsVendor();
                ArrayList<Vendors> allGroceryVendors  = VendorsData.getGroceryVendor();
                Vendors vegetableVendor = allVegetableVendors.get(ThreadLocalRandom.current().nextInt(0, allVegetableVendors.size()));
                Vendors fruitVendor = allFruitVendors.get(ThreadLocalRandom.current().nextInt(0, allFruitVendors.size()));
                Vendors groceryVendor = allGroceryVendors.get(ThreadLocalRandom.current().nextInt(0, allGroceryVendors.size()));
                while(sastaAmazon.isOpen){
                    String requirement=br.readLine();
                    if(requirement.equals("help")) SastaAmazon.helpMethod();
                     else if(Pattern.matches("[A-Za-z]+\\savail\\s[VGF]\\s[A-Za-z]+\\s[1-9][0-9]*",requirement)){
                        StringTokenizer st = new StringTokenizer(requirement);
                        String name = st.nextToken();
                        st.nextToken();
                        String type = st.nextToken();
                        String itemName = st.nextToken();
                        int quantity = Integer.parseInt(st.nextToken());
                        Vendors currentVendor = switch (type) {
                            case "V" -> vegetableVendor;
                            case "F" -> fruitVendor;
                            default -> groceryVendor;
                        };
                        System.out.println("Vendor: " + currentVendor.getSlogan());
                        SastaAmazon.availItems(itemName,currentVendor,quantity,sastaAmazon,name,false);
                    }
                    else if(Pattern.matches("[A-Za-z]+\\senter",requirement)){
                        StringTokenizer st = new StringTokenizer(requirement);
                        String name = st.nextToken();
                        SastaAmazon.createNewUser(sastaAmazon,name);
                    }
                    else if(Pattern.matches("[A-za-z]+\\sbuy\\s[VGF]\\s[A-Za-z]+\\s\\b[1-9][0-9]*\\b",requirement)){
                        StringTokenizer st = new StringTokenizer(requirement);
                        String name = st.nextToken();
                        st.nextToken();
                        String type = st.nextToken();
                        String itemName = st.nextToken();
                        int quantity = Integer.parseInt(st.nextToken());
                        Vendors currentVendor = switch (type) {
                            case "V" -> vegetableVendor;
                            case "F" -> fruitVendor;
                            default -> groceryVendor;
                        };
                        System.out.println("Vendor: " + currentVendor.getSlogan());
                        SastaAmazon.buyItems(currentVendor,sastaAmazon,name,quantity,itemName,type);
                    }
                    else if(Pattern.matches("[A-Za-z]+\\sexit",requirement)){
                        StringTokenizer st = new StringTokenizer(requirement);
                        String name = st.nextToken();
                        SastaAmazon.exitNewUser(sastaAmazon,name);
                        System.out.println("Good Bye  "+name);
                    }
                    else if(Pattern.matches("show\\s[VFG]",requirement)){
                        StringTokenizer st = new StringTokenizer(requirement);
                        st.nextToken();
                        String type = st.nextToken();
                        Vendors currentVendor = switch (type) {
                            case "V" -> vegetableVendor;
                            case "F" -> fruitVendor;
                            default -> groceryVendor;
                        };
                        System.out.println("Vendor: " + currentVendor.getSlogan());
                        for (Map.Entry<String, Items> entry : currentVendor.getItemsHashMap().entrySet()) {
                            String key = entry.getKey();
                            Items value = entry.getValue();
                            System.out.println("ItemName: "+key + "   Quantity: " + value.getQuntity() + "   Price: " + value.getItemPrice() + " ₹");
                        }
                    }
                    else if(Pattern.matches("[A-Za-z]+\\sclose",requirement)){
                        if(sastaAmazon.hashMap.size()>0){
                            System.out.println("U can't close bcz buyer exist");
                            continue;
                        }
                        sastaAmazon.isOpen = false;
                        System.out.println("|----------------------------|");
                        System.out.println("|       Market Closed        |");
                        System.out.println("|----------------------------|");
                        break;
                    }
                    else {
                        System.out.println("|-----------------------------------------|");
                        System.out.println("|          Command Not Found              |");
                        System.out.println("|       Write <help> for any help         |");
                        System.out.println("|_________________________________________|");
                    }
                }
            }
            else {
                System.out.println("only admin can open the market");
                break;
            }
        }
    }
}
