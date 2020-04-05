package com.company.behavioral.chain_of_responsibility.dispenser;

import java.util.Scanner;

public class Client {
    private AbstractDispenseChain c1;

    public Client() {
        this.c1 = new Dollar50Dispenser();
        Dollar20Dispenser c2 = new Dollar20Dispenser();
        Dollar10Dispenser c3 = new Dollar10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        Client atmDispenser = new Client();

        while (true) {
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            int amount = input.nextInt();

            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s");
                return;
            }

            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}
