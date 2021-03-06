/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Money extends MoneyValue {  //Extendar den abstrakta klassen så att man kan tilldela hur många av varje peng man vill ha
    //Attribut för Money
    private int amt;
    
    //Konstruktor där jag klassen ärver Value från MoneyValue
    public Money(int value) {
        super(value);
        this.amt = 1;
    }
    
    //Metoder för att göra pengar i alla svenska valörer upp till 100kr
    //parameterna tar in antalet man vill göra av varje valör.
    public static Money createOnes(int amt) {
        Money ones = new Money(1);
        ones.setAmt(ones.getAmt() * amt);
        return ones;
    } 
    
    public static Money createFives(int amt) {
        Money fives = new Money(5);
        fives.setAmt(fives.getAmt() * amt);
        return fives;
    }
    
    public static Money createTens(int amt) {
        Money tens = new Money(10);
        tens.setAmt(tens.getAmt() * amt);
        return tens;
    }
    
    public static Money createTwenties(int amt) {
        Money twenties = new Money(20);
        twenties.setAmt(twenties.getAmt() * amt);
        return twenties;
}
    
    public static Money createFifties(int amt) {
        Money fifties = new Money(50);
        fifties.setAmt(fifties.getAmt() * amt);
        return fifties;
    }
    
    public static Money createHundreds(int amt) {
       Money hundreds = new Money(100);
       hundreds.setAmt(hundreds.getAmt() * amt);
       return hundreds;
    }

    /**
     * @return the amt
     */
    public int getAmt() {
        return amt;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(int amt) {
        this.amt = amt;
    }

}
