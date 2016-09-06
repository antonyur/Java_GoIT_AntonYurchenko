package module4;


public class BankSystemImpl implements BankSystem {
    @Override
    public void withdrawOfUser(User user, int amount) {
        Bank userBank = user.getBank();
        if (amount > userBank.getLimitOfWithdrawal())
            amount = userBank.getLimitOfWithdrawal();
        user.setBalance(user.getBalance() - amount*(1 - 0.01*userBank.getCommission(amount)));
    }

    @Override
    public void fundUser(User user, int amount) {
        Bank userBank = user.getBank();
        if (amount > userBank.getLimitOfFunding())
            amount = userBank.getLimitOfFunding();
        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        Bank fromUserBank = fromUser.getBank();
        Bank toUserBank = toUser.getBank();
        int transferAmount = amount;
        if (amount > fromUserBank.getLimitOfWithdrawal())
            transferAmount = fromUserBank.getLimitOfWithdrawal();
        if (transferAmount > toUserBank.getLimitOfFunding())
            transferAmount = toUserBank.getLimitOfFunding();

        withdrawOfUser(fromUser, transferAmount);
        fundUser(toUser,transferAmount);
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
    }
}
