package module4;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank();
        usBank.setCurrency(Currency.EUR);
        Bank euBank = new EUBank();
        euBank.setCurrency(Currency.EUR);
        Bank chinaBank = new ChinaBank();
        chinaBank.setCurrency(Currency.EUR);

        User user1 = new User(1, "User1", 1000, 5,  "Company1", 1000, usBank);
        User user2 = new User(2, "User2", 2000, 10,  "Company2", 1100, usBank);
        User user3 = new User(3, "User3", 3000, 15,  "Company3", 1200, euBank);
        User user4 = new User(4, "User4", 4000, 20,  "Company3", 1400, euBank);
        User user5 = new User(5, "User5", 4000, 20,  "Company3", 1200, chinaBank);
        User user6 = new User(5, "User6", 40000, 20,  "Company4", 2000, chinaBank);

        BankSystem bs = new BankSystemImpl();
        System.out.println("before fund");
        System.out.println(user1);
        bs.fundUser(user1, 2000);
        System.out.println("after fund");
        System.out.println(user1);
        System.out.println("before paySalary");
        System.out.println(user2);
        bs.paySalary(user2);
        System.out.println("after paySalary");
        System.out.println(user2);
        System.out.println("before transferMoney");
        System.out.println(user4);
        System.out.println(user3);
        bs.transferMoney(user4, user3, 900);
        System.out.println("after transferMoney");
        System.out.println(user4);
        System.out.println(user3);
        System.out.println("before withdrawOfUser");
        System.out.println(user5);
        bs.withdrawOfUser(user5, 2000);
        System.out.println("after withdrawOfUser");
        System.out.println(user5);
    }
}
