package module9;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main4Tree {
    private static int arrSize = 10;

    public static boolean checkContainsName(TreeSet<Order> treeSet, String lastName)
    {
        return treeSet.stream().anyMatch(o -> o.getUser().getLastName().equals(lastName));
    }

    public static TreeSet<Order> deleteOrdersWithCurrency(TreeSet<Order> treeSet, String currency)
    {
        Predicate<Order> curEq = o -> o.getCurrency().getCurrencyCode().equals(currency);
        Set<Order> removed = treeSet.stream()
                .filter(curEq)
                .collect(Collectors.toSet());

        treeSet.removeAll(removed);
        return treeSet;
    }

    public static void main(String[] args) {
        Comparator<Order> comp = (o1, o2) -> Integer.compare(o2.getPrice(),o1.getPrice());

        TreeSet<Order> orderTreeSet = new TreeSet<>(comp);

        for (int i=1; i<arrSize; i++)//only arrSize-1, because 1 element is duplicated
        {
            String city = i%2==0 ? "Dnipro" : "Kyiv";

            User user = new User(i,"FirstName"+i,"LastName"+i,city,100*i);

            Currency c = i > arrSize/2 ? Currency.getInstance("UAH") : Currency.getInstance("USD");

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

        lastName = "LastName8";
        System.out.println("Contains name "+lastName);
        System.out.println(checkContainsName(orderTreeSet, lastName));

        System.out.println("Order with largest price "+orderTreeSet.first());

        orderTreeSet = deleteOrdersWithCurrency(orderTreeSet,"USD");
        System.out.println("TreeSet without USD currency "+orderTreeSet);
    }
}
