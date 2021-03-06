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
abstract class MoneyValue { //Abstract klass för pengar som bara initierar värdet av en peng
    //Attribut där jag anger värdet för varje valör
    int value;

    
    
    //Konstruktor för att ta fram en "Peng" i en viss valör
    public MoneyValue(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param aValue the value to set
     */
    public void setValue(int aValue) {
        value = aValue;
    }

    
    
    
    
}
