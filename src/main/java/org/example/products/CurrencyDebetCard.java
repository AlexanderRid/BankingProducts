package org.example.products;

import org.example.models.Currency;
import org.example.products.base.Card;

public class CurrencyDebetCard extends Card {

    public CurrencyDebetCard(Currency currency, long balance, String name) {
        super(currency, balance, name);
    }
}
