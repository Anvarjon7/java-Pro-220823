package de.telran.creational;

public class CoffixFactory extends AbstractFactory{

    @Override
    public AbstractCoffee createAbstractCoffee() { // Upcast
        return new CoffixCoffee();
    }

    @Override
    public AbstractCup createAbstractCup() {
        return new CoffixCup();
    }

    @Override
    public AbstractLid createAbstractLid() {
        return new CoffixLid();
    }
}
