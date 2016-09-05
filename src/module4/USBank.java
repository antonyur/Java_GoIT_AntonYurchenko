package module4;

public class USBank extends Bank {
    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

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
            return 0.01;
        else
        if (getCurrency() == Currency.EUR)
            return 0.015;
        else
            return 0;
    }

    @Override
    public double getCommission() {
        if (getCurrency() == Currency.USD) {
            if (getAvrSalaryOfEmployee() <= 1000)
                return 0.05;
            else
                return 0.07;
        }
        else
        if (getCurrency() == Currency.EUR) {
            if (getAvrSalaryOfEmployee() <= 1000)
                return 0.06;
            else
                return 0.08;
        }
        else
            return 0;

    }
}
