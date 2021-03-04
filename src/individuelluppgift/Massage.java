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
    String name;
    private static ArrayList<String> descriptionString;
    private static ArrayList<String> buyString;
    private static ArrayList<String> useString;
    private Wallet wallet;
    
    
    //Konstruktor
    public Massage() {
        super();
        name = "Massage";
        setCost(100);
        setType("Service");
        descriptionString = new ArrayList<>(); 
        buyString = new ArrayList<>();
        useString = new ArrayList<>();
        Description();
        Buy();
        Use();
    }
    
    
    
    @Override
    public void Description() {
        getDescriptionString().add("Have you ever dreamt about a nice hour with an AI? ");
        getDescriptionString().add(" ");
        getDescriptionString().add("Well, here I am, i am also quite cheap ;)");
    }

    @Override
    public void Buy() {
        getBuyString().add(" Congratulations to a new experience ");
        
    }
    

    @Override
    public void Use() {
        getUseString().add("LETS GOOOOO!!!!!!");
        getUseString().add(" ");
        getUseString().add(". ");
        getUseString().add(". ");
        getUseString().add("Dont expect a happy ending you perv");
    }

    @Override
    void Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the descriptionString
     */
    public static ArrayList<String> getDescriptionString() {
        return descriptionString;
    }

    /**
     * @param aDescriptionString the descriptionString to set
     */
    public static void setDescriptionString(ArrayList<String> aDescriptionString) {
        descriptionString = aDescriptionString;
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

    /**
     * @return the buyString
     */
    public static ArrayList<String> getBuyString() {
        return buyString;
    }

    /**
     * @param aBuyString the buyString to set
     */
    public static void setBuyString(ArrayList<String> aBuyString) {
        buyString = aBuyString;
    }

    /**
     * @return the useString
     */
    public static ArrayList<String> getUseString() {
        return useString;
    }

    /**
     * @param aUseString the useString to set
     */
    public static void setUseString(ArrayList<String> aUseString) {
        useString = aUseString;
    }

    
}
