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
public class Wallet {
    public ArrayList<Moneys> wallet;
    public int walletBalance;
    
    public Wallet() {
        wallet = new ArrayList<>();
        walletBalance = 0;
    }
    
    public void fillWallet(int amt) {
        Moneys ones = new Moneys(1, amt);
        this.wallet.add(ones);
        Moneys fives = new Moneys(5, amt);
        this.wallet.add(fives);
        Moneys tens = new Moneys(10, amt);
        this.wallet.add(tens);
        Moneys twentys = new Moneys(20, amt);
        this.wallet.add(twentys);
        Moneys fiftys = new Moneys(50, amt);
        this.wallet.add(fiftys);
        Moneys hundreds = new Moneys(100, amt);
        this.wallet.add(hundreds);
        walletBalance = 0;
        this.wallet.forEach((Moneys i) -> {
        walletBalance += (i.value * i.amt);
        });
    } //Klar, Bara kommentera
}
