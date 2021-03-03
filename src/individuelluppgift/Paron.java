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
public class Paron extends Product implements ProductInterface {
    //Attribut
    public ArrayList<String> descriptionString;
    public static ArrayList<String> buyString;
    public static ArrayList<String> useString;
    
    //Konstruktor
    public Paron() {
        name = "Pear";
        cost = 7;
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
        descriptionString.add("A wierd-looking edible. Some may call it sandy");
        descriptionString.add("and others might even eat it with its sticker on");
    }

    @Override
    public void Buy() {
        buyString.add("Congratulations to your new Pear");
    }
    

    @Override
    public void Use() {
        useString.add("'Have you never had an pear before????' - Mac");
        useString.add("");
        useString.add("Well.. Now I have!");
    }

    
}
