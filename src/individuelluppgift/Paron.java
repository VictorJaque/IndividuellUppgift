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
    final String name;
    private ArrayList<String> descriptionString;
    private static ArrayList<String> buyString;
    private static ArrayList<String> useString;
    
    //Konstruktor
    public Paron() {
        super();
        name = "Pear";
        setCost(7);
        setType("Food");
        descriptionString = new ArrayList<>(); 
        buyString = new ArrayList<>();
        useString = new ArrayList<>();
        Description();
        Buy();
        Use();
        
    }

    @Override
    public void Description() {
        getDescriptionString().add("A wierd-looking edible. Some may call it sandy");
        getDescriptionString().add("and others might even eat it with its sticker on");
    }

    @Override
    public void Buy() {
        getBuyString().add("Congratulations to your new Pear");
    }
    

    @Override
    public void Use() {
        getUseString().add("'Have you never had an pear before????' - Mac");
        getUseString().add("");
        getUseString().add("Well.. Now I have!");
    }

    @Override
    void Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the descriptionString
     */
    public ArrayList<String> getDescriptionString() {
        return descriptionString;
    }

    /**
     * @return the buyString
     */
    public static ArrayList<String> getBuyString() {
        return buyString;
    }

    /**
     * @return the useString
     */
    public static ArrayList<String> getUseString() {
        return useString;
    }

    
}
