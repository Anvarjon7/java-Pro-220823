package de.telran;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


class BaseClass {
    public static String field1 = "BaseClass.field1";

//    public static void show() {}
//
//    public void show(int value) {}
//    public void show(boolean value) {}

    protected void baseShow() {
        System.out.println("BaseClass.baseShow()");
    }
}

class DerivedClass extends BaseClass {
    public String field2 = "DerivedClass.field1";

    @Override
    public void baseShow() {
        super.baseShow();
        System.out.println("DerivedClass.baseShow()");

    }
}

abstract class MyAbstractClass {
    abstract void show();

    void show2() {
        System.out.println("....");
    }
}

interface MyInterface {
   void show();
   void show1();
   void show2();
   void show3();
}

@FunctionalInterface
interface FunctionInterface {
    void show();

}

public class Main {



    public static void main(String[] args) {
//        //casting
//        int value = 100;
//        short shortValue = (short) value;
//
//        final int value1 = 10;
//        byte value2 = value1;
//
//        MyClass myClass = new MyClass();
//        //String result = myClass.show();
//
//        ArrayList list1 = new ArrayList();
//        List list2 = new LinkedList();
//
//        Object o = new Object();
//
//        list1.add(o);
//        list2.add(o);
//
//        System.out.println(list1.equals(list2)); // true
//
//        int n = 5;
//        n = ++n + n++ + n++; // 11  // 6 + 6 + 7
//        System.out.println(n);

//        BaseClass baseClass = new DerivedClass(); // Upcast
//        baseClass.baseShow();
//        DerivedClass derivedClass = /*(DerivedClass)*/ DerivedClass.class.cast(baseClass);
//        derivedClass.derived();
//        derivedClass.baseShow();
//
   //     BaseClass baseClass1 = new BaseClass() ; // Upcast
        //Class<? extends BaseClass> aClass = baseClass1.getClass();
//        baseClass1.baseShow();
//        DerivedClass derivedClass3 = /*(DerivedClass)*/ DerivedClass.class.cast(baseClass1); // Downcast
//        derivedClass3.derived();
//        derivedClass3.baseShow();

        BaseClass baseClass = new DerivedClass(); // Upcast
        baseClass.baseShow();
        //DerivedClass derivedClass = /*(DerivedClass)*/ DerivedClass.class.cast(baseClass);
        //derivedClass.derived();
        //derivedClass.baseShow();

        Consumer<String> consumer = (String value ) -> System.out.println(value);
        Consumer<String> consumer2 = (String value ) -> System.out.println(value);
        consumer.andThen(consumer2);

        //consumer();

    }
}
