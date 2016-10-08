package module7;

import java.util.*;

public class Main4Tree {
    private static int arrSize = 10;

    public static boolean checkContainsName(TreeSet treeSet, String lastName)
    {
        Iterator<Order> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getUser().getLastName().equals(lastName))
                return true;
        }

        return false;
    }

    public static TreeSet deleteOrdersWithCurrency(TreeSet treeSet, String currency)
    {
        Iterator<Order> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getCurrency().getCurrencyCode().equals(currency))
                iterator.remove();
        }

        return treeSet;
    }

    public static void main(String[] args) {
        TreeSet<Order> orderTreeSet = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Integer.compare(o2.getPrice(),o1.getPrice());
            }
        });
        for (int i=1; i<arrSize; i++)//only arrSize-1, because 1 element is duplicated
        {
            String city = i%2==0 ? "Dnipro" : "Kyiv";

            User user = new User(i,"FirstName"+i,"LastName"+i,city,100*i);

            Currency c = i > arrSize/2 ? c = Currency.getInstance("UAH") : Currency.getInstance("USD");

            int initPrice = 500;

            Order o = new Order(i,initPrice*i,c,"Item"+i,"Shop1",user);

            orderTreeSet.add(o);
            if (i==1)
                orderTreeSet.add(o);//duplicate

        }

        System.out.println("Original treeSet");
        System.out.println(orderTreeSet);

        String lastName = "Petrov";
        System.out.println("Contains name "+lastName);
        System.out.println(checkContainsName(orderTreeSet, lastName));

        System.out.println("Order with largest price "+orderTreeSet.first());

        orderTreeSet = deleteOrdersWithCurrency(orderTreeSet,"USD");
        System.out.println("TreeSet without USD currency "+orderTreeSet);
    }
}
