package org.example.products.base;

import lombok.*;
import org.example.models.Currency;

//Предполагаю, что все поля при инициализации являются обязательными
@AllArgsConstructor
public abstract class BankingProducts implements Replenish {

    private Currency currency;
    //использую примитивы для простоты
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Long balance;
    private String name;

    @Override
    //По текущим требованиям, все банковские продукты имеют функцию пополнения
    public Long replenishment(Long value) {
        return balance = getBalance() + value;
    }
}
