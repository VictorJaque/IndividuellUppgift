/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import java.util.ArrayList;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Wallet {
    //Attribut
    private ArrayList<Money> wallet = new ArrayList<>();
    
    //Konstruktor
    public Wallet() {
        return wallet;
    }
    
    //Metoder
    public void deposit(int value,int amt) {
        //Fixa parameter och kod. Loop för att leta, sen ändra
        wallet.forEach(i -> {
            if (Money i.value == value) 
                i.amt += amt;
        });
        
    }
    
    public void withdrawal(int amt) {
        int amtLeft = amt;
        
        while (amtLeft > 0) {
            while (amtLeft > 100) {
                wallet.forEach(i -> {
                    if (amtLeft >= 100 && i.value == 100) {
                        i.amt -= 1;
                        amtLeft -=100;
                    }
                });
            }
            wallet.forEach(i -> {
                if (amtLeft >= 100 && i.value == 100) {
                    i.amt -= 1;
                    amtLeft -=100;
                } else if ((amtLeft >= 50 && amtLeft < 100) && i.value == 50) {
                    i.amt -= 1;
                    amtLeft -= 50;
                } else if ((amtLeft >= 20 && amtLeft < 50) && i.value == 20) {
                    i.amt -= 1;
                    amtLeft -=20;
                } else if ((amtLeft >= 10 && amtLeft < 20) && i.value == 10) {
                    i.amt -= 1;
                    amtLeft -= 10;
                } else if ((amtLeft >= 5 && amtLeft < 10) && i.value == 5) {
                    i.amt -= 1;
                    amtLeft -= 5;
                } else if ((amtLeft >=1 && amtLeft < 5) && i.value == 1) {
                    i.amt -= 1;
                    amtLeft -= 1;
                } 
            });
        }
    }
    
    public showBalance() {
        
    }
    
    public void fillWallet(int amt) {
        Money ones = new Money(1, amt);
        wallet.add(ones);
        Money fives = new Money(5, amt);
        wallet.add(fives);
        Money tens = new Money(10, amt);
        wallet.add(tens);
        Money twentys = new Money(20, amt);
        wallet.add(twentys);
        Money fiftys = new Money(50, amt);
        wallet.add(fiftys);
        Money hundreds = new Money(100, amt);
        wallet.add(hundreds);
    }
    
    public void createOnes(int amt) {
        Money ones = new Money(1, amt);
        wallet.add(ones);
    }
    
    public void createFives(int amt) {
        Money fives = new Money(5, amt);
        wallet.add(fives);
    }

    public void createTens(int amt) {
        Money tens = new Money(10, amt);
        wallet.add(tens);
    }
    
    public void createTwenties(int amt) {
        Money twenties = new Money(20, amt);
        wallet.add(twenties);
    }
    
    public void createFifties(int amt) {
        Money fifties = new Money(50, amt);
        wallet.add(fifties);
    }
    
    public void createHundreds(int amt) {
        Money hundreds = new Money(100, amt);
        wallet.add(hundreds);
    }
    
    
}
