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
    private String name;
    
    
    //Konstruktor
    public Massage() {
        super();
        name = "Massage";
        setCost(100);
        setType("Service");
    }
    
    
    
    @Override
    public void Description() {
        Menu.produceRow("Have you ever dreamt about a nice hour with an AI? ");
        Menu.produceRow(" ");
        Menu.produceRow("Well, here I am, i am also quite cheap ;)");
    }

    @Override
    public void Buy() {
        Menu.produceRow(" Congratulations to a new experience ");
        
    }
    

    @Override
    public void Use() {
        Menu.produceRow("LETS GOOOOO!!!!!!");
        Menu.produceRow(" ");
        Menu.produceRow(". ");
        Menu.produceRow(". ");
        Menu.produceRow("Dont expect a happy ending you perv");
    }

    @Override
    void Product() {
       name = "Massage";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
  
}
