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
public final class Massage extends Product implements ProductInterface {
    //Attribut
    public ArrayList<String> descriptionString;
    public static ArrayList<String> buyString;
    public static ArrayList<String> useString;
    
    
    //Konstruktor
    public Massage() extends Wallet {
        name = "Massage";
        cost = 100;
        type = "Service";
        descriptionString = new ArrayList<>(); 
        buyString = new ArrayList<>();
        useString = new ArrayList<>();
        Description();
        Buy();
        Use();
    }
    
    
    
    @Override
    public void Description() {
        descriptionString.add("Have you ever dreamt about a nice hour with an AI? ");
        descriptionString.add(" ");
        descriptionString.add("Well, here I am, i am also quite cheap ;)");
    }

    @Override
    public void Buy() {
        buyString.add(" Congratulations to a new experience ");
        
    }
    

    @Override
    public void Use() {
        useString.add("LETS GOOOOO!!!!!!");
        useString.add(" ");
        useString.add(". ");
        useString.add(". ");
        useString.add("Dont expect a happy ending you perv");
    }

    
}


/*        

    @Override
    public void Buy() {
        buyString.add("Congratulations to a new experience");
        
    }

    @Override
    public void Use() {
        useString.add("LETS GOOOOO!!!!!!");
        useString.add("");
        useString.add(". ");
        useString.add(". ");
        useString.add("Dont expect a happy ending you perv");*/