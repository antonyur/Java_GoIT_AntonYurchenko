package module4;

public class ChinaBank extends Bank{
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    public ChinaBank() {
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 100;
        else
        if (getCurrency() == Currency.EUR)
            return 150;
        else
            return 0;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.USD)
            return 10000;
        else
        if (getCurrency() == Currency.EUR)
            return 5000;
        else
            return 0;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USD)
            return 1;
        else
        if (getCurrency() == Currency.EUR)
            return 0;
        else
            return 0;
    }

    @Override
    public int getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 3;
            else
                return 4;
        }
        else
        if (getCurrency() == Currency.EUR) {
            if (amount <= 1000)
                return 1;
            else
                return 11;
        }
        else
            return 0;

    }


    @Override
    public String toString()
    {
        return "ChinaBank";
    }

}
