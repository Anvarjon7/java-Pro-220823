package de.telran.creational;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(new CoffixFactory());
        client.construct();
    }
}
