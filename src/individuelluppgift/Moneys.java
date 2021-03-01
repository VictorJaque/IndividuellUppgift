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
public class Moneys extends Money {
    //Attribut
    public int amt;
    
    //Konstruktor
    public Moneys(int value, int amt) {
        super(value);
        this.amt = amt;
    }
    
    //Metoder
    public static Moneys createOnes(int amt) {
        Moneys ones = new Moneys(1, amt);
        return ones;
    } 
    
    public static Moneys createFives(int amt) {
        Moneys fives = new Moneys(5, amt);
        return fives;
    }
    
    public static Moneys createTens(int amt) {
        Moneys tens = new Moneys(10, amt);
        return tens;
    }
    
    public static Moneys createTwenties(int amt) {
        Moneys twenties = new Moneys(20, amt);
        return twenties;
}
    
    public static Moneys createFifties(int amt) {
        Moneys fifties = new Moneys(50, amt);
        return fifties;
    }
    
    public static Moneys createHundreds(int amt) {
       Moneys hundreds = new Moneys(100, amt);
       return hundreds;
    }

}
