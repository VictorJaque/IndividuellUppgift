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

        
    }
    
    public withdrawal() {
        
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
    
    public Money createFives(int amt) {
        Money fives = new Money(5, amt);
        return fives;
    }

    public Money createTens(int amt) {
        Money tens = new Money(10, amt);
        return tens;
    }
    
    public Money createTwenties(int amt) {
        Money twenties = new Money(20, amt);
        return twenties;
    }
    
    public Money createFifties(int amt) {
        Money fifties = new Money(50, amt);
        return fifties;
    }
    
    public Money createHundreds(int amt) {
        Money hundreds = new Money(100, amt);
        return hundreds;
    }
    
    
}
