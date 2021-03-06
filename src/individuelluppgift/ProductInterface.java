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
public interface ProductInterface {
    
    //Mina metoder i mitt interface som finns i alla produkter.
    //Throws Interrupted Exception då jag vill att ibland ska konsolen 
    //stanna upp nån sekund eller 2 så att användaren hinner läsa
    
    void Description() throws InterruptedException;
    void Buy() throws InterruptedException;
    void Use() throws InterruptedException;
    
}
