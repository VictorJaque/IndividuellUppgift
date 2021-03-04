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
    
    //Konstruktor
    public Paron() {
        super();
        name = "Pear";
        setCost(7);
        setType("Food");  
    }

    @Override
    public void Description() {
        Menu.produceRow("A wierd-looking edible. Some may call it sandy");
        Menu.produceRow("and others might even eat it with its sticker on");
    }

    @Override
    public void Buy() {
        Menu.produceRow("Congratulations to your new Pear");
    }
    

    @Override
    public void Use() {
        Menu.produceRow("'Have you never had an pear before????' - Mac");
        Menu.produceRow("");
        Menu.produceRow("Well.. Now I have!");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    void Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
