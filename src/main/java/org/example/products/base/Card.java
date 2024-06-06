package org.example.products.base;


import org.example.models.Currency;

public abstract class Card extends BankingProducts implements Debeting {

    public Card(Currency currency, long balance, String name) {
        super(currency, balance, name);
    }

    @Override
    //Списание
    public void debeting(long value) {
        long balance = getBalance();
        this.setBalance(balance - value);
    }
}
