import org.example.models.Currency;
import org.example.products.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FunctionTest {

    private CreditCard product;
    private final long balance = 100;
    private final long value = 10;

    @BeforeMethod
    public void setup() {
        product = new CreditCard(Currency.RUB, balance, "creditName", 5);
    }

    @Test(description = "Проверка баланса")
    public void checkBalance() {
        Assert.assertEquals(product.getBalance(), 100);
    }

    @Test(description = "Проверка списания")
    public void checkDebeting() {
        product.debeting(value);
        Assert.assertEquals(product.getBalance(), 90);
    }

    @Test(description = "Проверка пополнения")
    public void checkReplenishment() {
        Assert.assertEquals(product.replenishment(value), balance + value);
    }

    @Test(description = "Проверка запроса задолженности, отсутствует задолженность")
    public void checkDebtRequestPositiveBalance () {
        Assert.assertEquals(product.debtRequest(), 0);
    }

    @Test(description = "Проверка запроса задолженности, присутствует задолженность")
    public void checkDebtRequestNegaviteBalance () {
        long balance = -5;
        CreditCard creditCard = new CreditCard(Currency.RUB, balance, "creditName", 5);
        Assert.assertEquals(creditCard.debtRequest(), balance);
    }


    @Test(description = "Проверка закрытия депозита")
    public void checkCloseDeposit () {
        Deposit deposit = new Deposit(Currency.RUB,balance, "depositName");
        deposit.closeDeposit();
    }
}
