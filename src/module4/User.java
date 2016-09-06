package module4;


public class User {
    private long id;
    private String name;
    private double balance;
    private int monthsOfEmploymen;
    private String companyName;
    private int salary;
    private Bank bank;

    public User(long id, String name, double balance, int monthsOfEmploymen, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthsOfEmploymen = monthsOfEmploymen;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmploymen() {
        return monthsOfEmploymen;
    }

    public void setMonthsOfEmploymen(int monthsOfEmploymen) {
        this.monthsOfEmploymen = monthsOfEmploymen;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s", name, balance);
    }
}
