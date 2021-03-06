/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import static individuelluppgift.Menu.produceBottom;
import static individuelluppgift.Menu.produceRow;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public final class Massage extends Product implements ProductInterface {
    //Attribut som inte ärvs
    private String name;
    
    //Konstruktor som ärver från aden abstrakta klassen samt tilldelar nya värden
    public Massage(int value, String type, int bankBalance) {
        super(value, type);
        this.bankBalance = bankBalance;
        name = "Massage";
    }
    
    //Metod för att visa vad produkten innehåller
    //Ger användaren ett alternativ att handla produkten
    @Override
    public void Description() throws InterruptedException {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow(name);
        produceRow("");
        Menu.walletShow(bankBalance);
        produceRow("Have you ever dreamt about a nice hour with an AI? ");
        produceRow(" ");
        produceRow("Well, here I am, i am also quite cheap ;)");
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
    
    //Metod som kollar att man har tillräckligt mycket med pengar på sitt saldo
    //så man inte ger ut saker gratis... hur skulle det se ut?
    @Override
    public void Buy() throws InterruptedException{
        if (bankBalance >= value) {
            bankBalance -= value;
            Menu.clearScreen();
            Menu.produceLine();
            Menu.produceRow("");
            Menu.produceRow(" Congratulations to a new experience ");
            Menu.produceRow("");
            Menu.produceLine();
            TimeUnit.SECONDS.sleep(1);
            Use();
        } else {Menu.tryAgainTxt();}
    }
    
    //Sista metod för att använda den. Går igång automatiskt när köpet är genomförrt
    @Override
    public void Use() throws InterruptedException {
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("");
        Menu.produceRow("LETS GOOOOO!!!!!!");
        Menu.produceRow(" ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("");
        Menu.produceRow("LETS GOOOOO!!!!!!");
        Menu.produceRow(". ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("");
        Menu.produceRow("LETS GOOOOO!!!!!!");
        Menu.produceRow(". . ");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(1);
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow("");
        Menu.produceRow("LETS GOOOOO!!!!!!");
        Menu.produceRow(". . ");
        Menu.produceRow("Dont expect a happy ending you perv");
        Menu.produceLine();
        TimeUnit.SECONDS.sleep(2);

    }
}

