package org.example.products;

import org.example.models.Currency;
import org.example.products.base.BankingProducts;

public class Deposit extends BankingProducts  {

    public Deposit(Currency currency, long balance, String name) {
        super(currency, balance, name);
    }

    public void closeDeposit (){
        //...
    }

}
