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
public final class Apple extends Product implements ProductInterface {
    //Attribut
    public ArrayList<String> descriptionString;
    public static ArrayList<String> buyString;
    public static ArrayList<String> useString;
    
    //Konstruktor
    public Apple() {
        name = "Apple";
        cost = 10;
        type = "Food";
        descriptionString = new ArrayList<>(); 
        buyString = new ArrayList<>();
        useString = new ArrayList<>();
        Description();
        Buy();
        Use();
    }
    
    
    
    @Override
    public void Description() {
        descriptionString.add("A large, chrunchy and juicy fruit that most people loves.");
        descriptionString.add("But watch out if your a kid, your tooth might get stuck");
    }

    @Override
    public void Buy() {
        buyString.add("Congratulations to your new apple ");  
    }
    

    @Override
    public void Use() {
        useString.add("You take a bite.");
        useString.add("'Wow, this is one of the most juicy apples I ever had'");
    }


}
