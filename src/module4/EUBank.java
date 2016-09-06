package module4;


public class EUBank extends Bank {
    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 2000;
        else
        if (getCurrency() == Currency.EUR)
            return 2200;
        else
            return 0;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.USD)
            return 10000;
        else
        if (getCurrency() == Currency.EUR)
            return 20000;
        else
            return 0;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USD)
            return 0;
        else
        if (getCurrency() == Currency.EUR)
            return 1;
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
                return 2;
            else
                return 4;
        }
        else
            return 0;

    }

    @Override
    public String toString()
    {
        return "EUBank";
    }

}
