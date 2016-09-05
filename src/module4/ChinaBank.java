package module4;

public class ChinaBank extends Bank{
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
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
            return 0.01;
        else
        if (getCurrency() == Currency.EUR)
            return 0;
        else
            return 0;
    }

    @Override
    public double getCommission() {
        if (getCurrency() == Currency.USD) {
            if (getAvrSalaryOfEmployee() <= 1000)
                return 0.03;
            else
                return 0.04;
        }
        else
        if (getCurrency() == Currency.EUR) {
            if (getAvrSalaryOfEmployee() <= 1000)
                return 0.1;
            else
                return 0.11;
        }
        else
            return 0;

    }

}
