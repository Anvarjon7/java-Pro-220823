package de.telran.creational;

/**
 * Абстрактная фабрика (kit - набор инструментов) - предоставляет клиенту интерфейс
 * для создания семейств взаимосвязанных или взаимозависимых объектов-продуктов, при
 * этом скрывает от клиента информации о конкретных классах создаваемых
 * объектов-продуктов.
 *
 * DIP - Dependency Inversion Principle
 * DI - Dependency Injection (автор Мартин Фаулер)
 */

public abstract class AbstractFactory { // extends ConcreteClass
    public abstract AbstractCoffee createAbstractCoffee();
    public abstract AbstractCup createAbstractCup();
    public abstract AbstractLid createAbstractLid();
}
