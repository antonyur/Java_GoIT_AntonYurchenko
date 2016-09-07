package module4;


import org.junit.Assert;
import org.junit.Test;

public class BankSystemImplTest {
    @Test
    public void withdrawOfUser() {
        Bank usBank = new USBank();
        usBank.setCurrency(Currency.EUR);
        User user = new User(1, "User", 10000, 5, "Company", 1000, usBank);
        BankSystem bs = new BankSystemImpl();
        bs.withdrawOfUser(user, 500);
        Assert.assertEquals(9470, user.getBalance(), 0);
    }
}
