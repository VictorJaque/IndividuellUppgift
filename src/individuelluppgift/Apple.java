/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Apple extends Product implements ProductInterface {
    //Attribut
    private final String type;
    //Konstruktor
    public Apple(String name, int cost, String type) {
        super(name, cost);
        this.type = type;
    }
    
    
    
    @Override
    public void Description() {
        System.out.println("A large, chrunchy and juicy fruit that most people loves. But watch out if your a kid, your tooth might get stuck");
    }

    @Override
    public void Buy() {
        
    }

    @Override
    public void Use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
