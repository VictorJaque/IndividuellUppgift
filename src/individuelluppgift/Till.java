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
public class Till {
    //Attribut
    public int saldo;
    
    //Konstruktor
    public Till(int saldo) {
        this.saldo = saldo;
    }
    
    public void deposit(int value) {
        saldo += value * amt;
    
    }

    public void withdrawal(int value) {
        saldo -= value
    }
    
}
