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
abstract class Product {
    //attribut
    public String name;
    public int cost;
    //Konstruktor
    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
