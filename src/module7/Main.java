package module7;


import java.util.*;

public class Main {

    private static int arrSize = 10;

    public static ArrayList<Order> descendingOrder(ArrayList<Order> orderList){
        ArrayList<Order> orderList1 = new ArrayList<Order>(orderList);
        orderList1.sort(new Comparator<Order>(){
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getPrice()-o1.getPrice();
            }
        });

        return orderList1;
    }

    public static ArrayList<Order> ascendingOrderByPriceAndUserCity(ArrayList<Order> orderList){
        ArrayList<Order> orderList1 = new ArrayList<Order>();
        orderList1.addAll(orderList);
        orderList1.get(0).setPrice(orderList1.get(1).getPrice());
        orderList1.sort(new Comparator<Order>(){
            @Override
            public int compare(Order o1, Order o2) {
                int difPrice = o1.getPrice()-o2.getPrice();
                if (difPrice!=0)
                    return difPrice;

                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });

        return orderList1;
    }

    public static ArrayList<Order> ascendingOrderByItemNameAndShopIdAndUserCity(ArrayList<Order> orderList){
        ArrayList<Order> orderList1 = new ArrayList<Order>(orderList);
        orderList1.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int r1 = o1.getItemName().compareTo(o2.getItemName());
                if (r1 != 0)
                    return r1;

                int r2 = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
                if (r2 != 0)
                    return r2;

                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });

        return orderList1;
    }

    public static void main(String[] args) {

        ArrayList<Order> orderList = new ArrayList<>();
        for (int i=1; i<=arrSize; i++)
        {
            String city = "Kyiv";
            if (i%2==0)
                city = "Dnipro";
            User user = new User(i,"FirstName"+i,"LastName"+i,city,100*i);

            Currency c = Currency.getInstance("USD");
            if (i > arrSize/2)
                c = Currency.getInstance("UAH");

            int initPrice = 500;

            orderList.add(new Order(i,initPrice*i,c,"Item"+i,"Shop1",user));
        }

        System.out.println("Original list");
        System.out.println(orderList);

        List<Order> orderList1 = descendingOrder(orderList);
        System.out.println("Descending order");
        System.out.println(orderList1);

        List<Order> orderList2 = ascendingOrderByPriceAndUserCity(orderList);
        System.out.println("Ascending order by price and user city");
        System.out.println(orderList2);


        List<Order> orderList3 = ascendingOrderByItemNameAndShopIdAndUserCity(orderList);
        System.out.println("Ascending order by itemName, ShopId and user city");
        System.out.println(orderList3);


        List<Order> orderList4 = new ArrayList<Order>(orderList);
        orderList4.set(1, orderList4.get(2));

        System.out.println("2 and 3 elements are equal");
        System.out.println(orderList4);

        Set<Order> noDuplicates = new LinkedHashSet<Order>(orderList4);

        System.out.println("noDuplicates");
        System.out.println(noDuplicates);

        //delete items where price less than 1500
        List<Order> orderList5 = new ArrayList<Order>(orderList);
        for (Iterator<Order> it=orderList5.iterator(); it.hasNext();) {
            if (it.next().getPrice() < 1500)
                it.remove();
        }
        System.out.println(orderList5);


        System.out.println("original list");
        System.out.println(orderList);

        //separate list for two list - orders in USD and UAH
        List<Order> orderListUSD = new ArrayList<Order>();
        List<Order> orderListUAH = new ArrayList<Order>();

        Iterator<Order> itr = orderList.iterator();
        while (itr.hasNext()) {
            //System.out.println(itr.next());
            Order o = itr.next();
            if (o.getCurrency().getCurrencyCode().equalsIgnoreCase("USD")) {
                orderListUSD.add(o);
            }
            if (o.getCurrency().getCurrencyCode().equalsIgnoreCase("UAH")) {
                orderListUAH.add(o);
            }
        }

        System.out.println("list of USD");
        System.out.println(orderListUSD);
        System.out.println("list of UAH");
        System.out.println(orderListUAH);


        //separate list for as many lists as many unique cities are in User
        HashMap<String, ArrayList<Order>> hashmap = new HashMap<String, ArrayList<Order>>();
        Iterator<Order> itr1 = orderList.iterator();
        while (itr1.hasNext()) {
            Order o = itr1.next();
            if (hashmap.containsKey(o.getUser().getCity())) {
                List<Order> list = hashmap.get(o.getUser().getCity());
                list.add(o);
            }
            else
            {
                ArrayList<Order> list1 = new ArrayList<Order>();
                list1.add(o);
                hashmap.put(o.getUser().getCity(), list1);
            }
        }
        ArrayList<ArrayList<Order>> resultList = new ArrayList<ArrayList<Order>>();
        resultList.addAll(hashmap.values());
        System.out.println("Lists of orders with unique user city");
        System.out.println(hashmap.values());

    }
}
