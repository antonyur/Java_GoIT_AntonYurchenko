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
            return 0.01;
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
                return 0.02;
            else
                return 0.04;
        }
        else
            return 0;

    }

}
