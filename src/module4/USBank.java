package module4;

public class USBank extends Bank {
    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    public USBank() {}

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 1000;
        else
            if (getCurrency() == Currency.EUR)
                return 1200;
            else
                return 0;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.USD)
            return Integer.MAX_VALUE;
        else
        if (getCurrency() == Currency.EUR)
            return 10000;
        else
            return 0;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USD)
            return 1;
        else
        if (getCurrency() == Currency.EUR)
            return 1.5;
        else
            return 0;
    }

    @Override
    public int getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 5;
            else
                return 7;
        }
        else
        if (getCurrency() == Currency.EUR) {
            if (amount <= 1000)
                return 6;
            else
                return 8;
        }
        else
            return 0;

    }

    @Override
    public String toString()
    {
        return "USBank";
    }
}
