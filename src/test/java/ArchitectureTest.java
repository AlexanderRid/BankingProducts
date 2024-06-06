import org.example.models.Currency;
import org.example.products.CreditCard;
import org.example.products.CurrencyDebetCard;
import org.example.products.DebitCard;
import org.example.products.Deposit;
import org.example.products.base.BankingProducts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArchitectureTest {

    private List<String> cardMethods;
    private List<String> depositMethods;
    private final long balance = 100;

    @BeforeMethod
    public void setup () {
        cardMethods = new ArrayList<>() {{
            add("replenishment");
            add("debeting");
            add("getBalance");
        }};

        depositMethods = new ArrayList<>(){{
            add("replenishment");
            add("getBalance");
            add("closeDeposit");
        }};
    }


    @Test(description = "Проверяем, что класс DebitCard является банковским продуктом и содержит все необходимые методы")
    public void checkDebitCardClass () {
        List<String> debitCardMethods = cardMethods;

        DebitCard debitCard = new DebitCard(Currency.RUB,balance, "debitName");

        Assert.assertTrue(debitCard instanceof BankingProducts);

        Assert.assertTrue(Arrays.stream(debitCard.getClass().getMethods())
                .map(Method::getName)
                .toList()
                .containsAll(debitCardMethods));
    }

    @Test(description = "Проверяем, что CreditCard является банковским продуктом и содержит все необходимые методы")
    public void checkCreditCardClass () {
        List<String> creditCardMethods = cardMethods;
        creditCardMethods.add("debtRequest");

        CreditCard creditCard = new CreditCard(Currency.RUB,balance, "debitName", 5);
        Assert.assertTrue(creditCard instanceof BankingProducts);

        Assert.assertTrue(Arrays.stream(creditCard.getClass().getMethods())
                .map(Method::getName)
                .toList()
                .containsAll(creditCardMethods));
    }

    @Test(description = "Проверяем, что CurrencyDebetCard является банковским продуктом и содержит все необходимые методы")
    public void checkCurrencyDebetCardClass () {
        List<String> currencyDebetCardMethods = cardMethods;

        CurrencyDebetCard currencyDebetCard = new CurrencyDebetCard(Currency.RUB,balance, "debitName");
        Assert.assertTrue(currencyDebetCard instanceof BankingProducts);

        Assert.assertTrue(Arrays.stream(currencyDebetCard.getClass().getMethods())
                .map(Method::getName)
                .toList()
                .containsAll(currencyDebetCardMethods));
    }

    @Test(description = "Проверяем, что Deposit является банковским продуктом и содержит все необходимые методы")
    public void checkDepositClass () {
        List<String> depositMethods = new ArrayList<>(){{
            add("replenishment");
            add("getBalance");
            add("closeDeposit");
        }};

        Deposit deposit = new Deposit(Currency.RUB,balance, "debitName");
        Assert.assertTrue(deposit instanceof BankingProducts);

        Assert.assertTrue(Arrays.stream(deposit.getClass().getMethods())
                .map(Method::getName)
                .toList()
                .containsAll(depositMethods));
    }
}
