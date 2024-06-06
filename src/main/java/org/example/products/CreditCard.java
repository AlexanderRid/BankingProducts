package org.example.products;

import org.example.models.Currency;
import org.example.products.base.Card;

public class CreditCard extends Card {

    private long interestRate;

    public CreditCard(Currency currency, long balance, String name, long interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    //Запрос задолженности
    public long debtRequest() {
        long balance = getBalance();
        return balance < 0 ? balance : 0;
    }
}
