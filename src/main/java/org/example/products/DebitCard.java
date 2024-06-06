package org.example.products;

import org.example.models.Currency;
import org.example.products.base.Card;

public class DebitCard extends Card {

    public DebitCard(Currency currency, long balance, String name) {
        super(currency, balance, name);
    }
}
