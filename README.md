
/**
* casting - преобразование значения типа
*
* cast - преведение типов
*
* 8 примитивных типов + ссылка
*
* boolean - какой размер?
*
* Парадигма - это совокупность идей и понятий, которые определяют стиль написания кода.
* ООП
* 1) Инкапсуляция
*     a) Сокрытие типов данных (var)
*     b) Сокрытие реализации
*              1) Использование модификаторов доступа (public, private и т.д.)
*  *           2) Upcast
*     c) Инкапсуляция вариации - сокрытие частей информационных систем
* 2) Наследование - это передача открытых и защищенных состояний и поведений от базового класса к производному.
    
    Базовый класс - Производный класс
    Суппер класс - Подкласс (сабкласс)
    Родительский класс - Дочерний класс
    Родитель - Потомок

* 3) Полиморфизм
*     a) ad-hoc полиморфизм
*     b) Классический (принудительный) полиморфизм
*          1) Использование виртуальных членов
*          2) Upcast и Downcast
  * 4) Абстракция - это придание объекту характеристик, которые отличают его от всех других объектов,
      четко определяя концептуальные границы.
    
      Абстрагирование - это способ выделить набор значимых характеристик объекта, исключая из рассмотрения не значимые, 
      т.е абстракция - это набор всех таких характеристик.
  
            Закон движения познания (В.И. Ленин) (Философия Гегеля)

            Абстактные классы и интерфейсы имею различную природу(разные формы абстракции)

* 5) Посылка сообщений
* 6) Повторное использование ()

* Функциональные языки
* 7) замыкание
* 8) Мемоизация
* 9) Карирование
* ...
* ~ 19 парадигм
*
*
*/

Класс это конструкция языка, тип относится к объекту!

class MyClass { // операторные скобки
// Тип - это имя используемое для обозначения конкретного интерфейса.
// Тип - это всего лишь способ группировки данных для выделения определенного функционала и предметной области,
// выделение объекта или cущности, которые имеют свои характеристики и поведения!

    private String state;




}
// Интерфейс - это набор сигнатур методов
//
/*
В сигнатуру методов входит:
1) Тип возвращаемого значения - в java в сигнатуру метода не входит, например MSIL, тип возвращаемого значения включает
2) Имя метода
3) Типы параметров
*/
interface Animal {
void eat();
//int eat();
void run();
}

class Cat implements Animal {

    void catchMouse() {}

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }
}

class Dog implements Animal{

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }
}
