package de.telran.creational;

public class CoffixCup extends AbstractCup {
    @Override
    public void interaction(AbstractCoffee abstractCoffee) {
        System.out.println(this + " interaction with " + abstractCoffee);
    }
}
