package de.telran.creational;

/**
 *
 * Связанность - мера зависимости одно объекта от другого. (low cuplin)
 * Связность - мера самодостаточности(определяет функциональную полноту) (high cophition)
 */

// Инкапсуляция вариации
public class Client {

    private AbstractCoffee coffee;
    private AbstractCup cup;
    private AbstractLid lid;

    public Client(AbstractFactory factory) { // абстрактная связанность
        // абстрагирование процесса инстанцирования
        this.coffee = factory.createAbstractCoffee();
        this.cup = factory.createAbstractCup();
        this.lid = factory.createAbstractLid();
    }

    public void construct() {
        // абстрагирование вариантов использования
        this.cup.interaction(coffee);
    }
}
