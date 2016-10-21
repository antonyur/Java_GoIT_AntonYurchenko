package module9;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static int arrSize = 10;

    public static List<Order> descendingOrder(ArrayList<Order> orderList){
        return orderList.stream().sorted((o1, o2) -> o2.getPrice() - o1.getPrice())
                .collect(Collectors.toList());
    }

    public static List<Order> ascendingOrderByPriceAndUserCity(ArrayList<Order> orderList){
        return orderList.stream().sorted((o1, o2) -> {
            int difPrice = o1.getPrice()-o2.getPrice();
            if (difPrice!=0)
                return difPrice;

            return o1.getUser().getCity().compareTo(o2.getUser().getCity());
        }).collect(Collectors.toList());
    }

    public static List<Order> ascendingOrderByItemNameAndShopIdAndUserCity(ArrayList<Order> orderList){
        return orderList.stream().sorted((o1, o2) -> {
            int r1 = o1.getItemName().compareTo(o2.getItemName());
            if (r1 != 0)
                return r1;

            int r2 = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
            if (r2 != 0)
                return r2;

            return o1.getUser().getCity().compareTo(o2.getUser().getCity());
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        ArrayList<Order> orderList = new ArrayList<>();
        for (int i=1; i<=arrSize; i++)
        {
            String city = i%2==0 ? "Dnipro" : "Kyiv";

            User user = new User(i,"FirstName"+i,"LastName"+i,city,100*i);

            Currency c = i > arrSize/2 ? Currency.getInstance("UAH") : Currency.getInstance("USD");

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

        orderList4 = orderList4.stream().distinct().collect(Collectors.toList());

        System.out.println("noDuplicates");
        System.out.println(orderList4);

        System.out.println("delete items where price less than 1500");
        List<Order> orderList5 = orderList.stream()
                .filter(o -> o.getPrice() >= 1500)
                .collect(Collectors.toList());
        System.out.println(orderList5);

        System.out.println("original list");
        System.out.println(orderList);

        //separate list for two list - orders in USD and UAH
        List<Order> orderListUSD = orderList.stream()
                .filter(o -> o.getCurrency().getCurrencyCode().equalsIgnoreCase("USD"))
                .collect(Collectors.toList());

        List<Order> orderListUAH = orderList.stream()
                .filter(o -> o.getCurrency().getCurrencyCode().equalsIgnoreCase("UAH"))
                .collect(Collectors.toList());

        System.out.println("list of USD");
        System.out.println(orderListUSD);
        System.out.println("list of UAH");
        System.out.println(orderListUAH);


        //separate list for as many lists as many unique cities are in User
        Collection<List<Order>> resultList = orderList.stream().collect(Collectors.groupingBy((o) -> o.getUser().getCity())).values();
        System.out.println("Lists of orders with unique user city by streams: ");
        System.out.println(resultList);

        /*HashMap<String, ArrayList<Order>> hashmap = new HashMap<String, ArrayList<Order>>();
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
        ArrayList<ArrayList<Order>> resultList1= new ArrayList<ArrayList<Order>>();
        resultList1.addAll(hashmap.values());
        System.out.println("Lists of orders with unique user city by iterators: ");
        System.out.println(hashmap.values());*/

    }
}
