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
abstract class Money { //Abstract klass för pengar som bara initierar värdet av en peng
    //Attribut där jag anger värdet för varje valör samt hur många
    public final int value;

    
    
    //Konstruktor
    public Money(int value) {
        this.value = value;
    }

    
    
    
    
}
