package coffee_machine;

import annotations.Author;
import coffee_machine.enums.CoffeeSize;
import coffee_machine.enums.CoffeeType;
import coffee_machine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
        private List<Coffee> coffeeList;
        private int money;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
    }

    @Author(name = "Nedqlko")
    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();
    }

    @Author(name = "Pesho")
    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(Enum.valueOf(CoffeeSize.class, size.toUpperCase()),
                Enum.valueOf(CoffeeType.class, type.toUpperCase()));
        if (coffee.getPrice() <= this.money) {
         this.coffeeList.add(coffee);
         this.money = 0;
        }
    }
@Author(name = "Gosho")
    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }

}

