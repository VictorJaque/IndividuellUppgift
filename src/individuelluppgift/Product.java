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
abstract class Product extends Menu {
    //Attribut som alla andra klasser ska ärva från 
    //Jag har valt att ärva från min klass Menu då det är den som ska 
    //hantera produkterna 
    private static String type;
    
    //Konstruktor med Value och Type som parameters 
    public Product(int value, String type) {
        super(value);
        this.type = type;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
