/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import static individuelluppgift.Menu.clearScreen;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Car extends Product implements ProductInterface {
    private String name;
    public static int bankBalance;

    public Car(int value, String type, int bankBalance) {
        super(value, type);
        this.bankBalance = bankBalance;
        name = "Car";
    }


    @Override
    void Product() {
    }

    @Override
    public void Description() throws InterruptedException {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow(name);
        produceRow("");
        Menu.walletShow(bankBalance);
        produceRow("Do you want to buy a cheap used car in a vending machine? ");
        produceRow(" ");
        produceRow("I can't garuantee that it is totally safe tho!");
        produceRow("");
        produceRow("Cost: " + String.valueOf(value));
        produceRow("Press 1 to buy!");
        produceBottom();
        Scanner scan = new Scanner(System.in);
        int MenuChoice = scan.nextInt();
        if (MenuChoice == 1) {
                boolean areYouSure = Menu.areYouSure();
                if (areYouSure) {
                    Buy();
                }

        }
    }

    @Override
    public void Buy() throws InterruptedException {
        if (bankBalance >= value) {
            bankBalance -= value;
            Menu.clearScreen();
            Menu.produceLine();
            Menu.produceRow("");
            Menu.produceRow(" Congratulations to a new ride");
            Menu.produceRow("");
            Menu.produceLine();
            TimeUnit.SECONDS.sleep(1);
            Use();
        } else {Menu.tryAgainTxt();}
    }

    @Override
    public void Use() throws InterruptedException {
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("");
        Menu.produceRow("Jump IN!!");
        Menu.produceRow(" ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("Jump IN!!");
        Menu.produceRow(". ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow(". . ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("Jump IN!!");
        Menu.produceRow("VROOOOOOOOOOM!!!!");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(2);

    }
}
