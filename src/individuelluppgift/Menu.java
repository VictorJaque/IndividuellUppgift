/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Menu extends Wallet{
    //Attribut för "kiosken". en int variabel för fysisk plånbok, en för kiosk
    //samt en array list för min klass Moneys (derived från Money)
    private static int bankBalance; //Saldo för kiosk
    public static Paron pear;      //Min första produkt
    public static Massage massage;     //Min andra produkt
    static Wallet wallet;
    //Konstruktor
    public Menu(Wallet wallet) {  //När jag initierar objektet vill jag att den ska vara tom på pengar
        this.wallet = wallet;
        bankBalance = 0;
        pear = new Paron();
        massage = new Massage();

    }
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here   
        Wallet userWallet = new Wallet();
        userWallet.fillWallet(10);
        startMenu(userWallet);   //Startar användarmenyn
        

    }    
        
        

    @SuppressWarnings("fallthrough")
    public static void startMenu(Wallet userWallet) throws InterruptedException {       // Första sidan av menyn där man kan välja om man vill handla produkter eller sätta in pengar i automaten
        boolean startMenu = true;   //använder en lokal boolean i en while loop som producerar ny text efter varje input från användaren ifall den inte skulle mata in rätt
        Scanner scan = new Scanner(System.in);  //Initierar en scanner för att användaren ska kunna mata in sitt val
        while (startMenu) {
            clearScreen();
            produceLine();
            produceRow(" ");
            produceRow("Greetings simple human!");
            produceRow(" ");
            produceLine();
            produceRow(" ");
            produceRow("This is vicJaq1337s next level e-store");
            produceRow("Super cool, right?");
            produceRow(" ");
            produceLine();
            produceRow(" ");
            produceRow("Select one of the following choices:");
            produceRow("1. Open Bank of vicJaq1337s next level e-store");
            produceRow("2. Check out the best sortiment of the world in vicJaq1337s next level e-store");
            produceRow(" ");
            produceLine();
            produceRow("Press 0 to exit vicJaq1337s next level e-store now");
            produceLine();
            int menuChoice = scan.nextInt();
            switch(menuChoice) { // Switch case för att komma in på de olika alternativen
                case 0:
                    boolean areYouSure = areYouSure(); //Funktion som frågar användaren om deen är säker
                    if (areYouSure) {
                        //Avslutar programmet
                        startMenu = false;
                        withdrawalBankExit();
                        break;
                    }
                case 1:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Öppnar banken
                        openBank(userWallet);
                        break;
                    }
                case 2:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Öppnar affären
                        openShop(userWallet);
                        break;
                    }
                    
                default: tryAgainTxt();
                }
            }  
        } 
    
    public static void openBank(Wallet userWallet) throws InterruptedException {  //Startsida för banken. Samma logik här som tidigar
        boolean waitForInp = true; 
        while(waitForInp) {
            clearScreen();
            produceBankTop();
            produceRow("Select one of the following choices: ");
            produceRow("1. Deposit money to current account                          ");
            produceRow("2. Withdrawal money from vicJaq1337s next level e-store      ");
            produceRow("3. Check Balance                                             ");
            produceBottom();
            Scanner scan = new Scanner(System.in);
            int menuChoice = scan.nextInt();
            switch(menuChoice) {
                case 0 -> {
                    boolean areYouSure = areYouSure();
                    if (areYouSure) {
                        //Avslutar och går tillbaka till startsidan
                        waitForInp = false;
                    }
                }
                case 1 -> //Sätter in pengar 
                    userWallet.depositBank();
                case 2 -> //Tar ut pengar
                    userWallet.withdrawalBank();
                case 3 -> //Kollar saldot 
                    userWallet.checkBalance();
                default -> tryAgainTxt();
                }
            }
    } 
    
    @SuppressWarnings("fallthrough")
    public static void openShop(Wallet userWallet) throws InterruptedException {  //Startsida för affären. Samma logik här som tidigare startsidor
        clearScreen();
        produceTop();
        produceRow("Select one of the following choices:");
        produceRow("1. Massage");
        produceRow("2. Pear");
        produceRow("");
        produceBottom();
       
        Scanner scan = new Scanner(System.in);
        int menuChoice = scan.nextInt();
        boolean waitForInput = true;
        while (waitForInput)
            switch(menuChoice) {
                case 0: //avslutar den här sidan
                    boolean areYouSure = areYouSure();
                    if (areYouSure) {
                        waitForInput = false;
                    }
                case 1:  // hämtar en funktion för att visa information om varan "Apple"
                    Massage menuMassage = new Massage();
                    menuMassage.Description();
                    int secondChoice = scan.nextInt();
                    if (secondChoice == 1) {
                        produceTop();
                        menuMassage.Buy();
                        produceBottom();
                        TimeUnit.SECONDS.sleep(1);
                        produceTop();
                        menuMassage.Use();
                        produceBottom();
                        break;
                    }                    
                case 2:  // hämtar en funktion för att visa information om varan "Pear"
                    Paron menuPear = new Paron();
                    menuPear.Description();
                    menuChoice = scan.nextInt();
                    if (menuChoice == 1) {
                        produceTop();
                        menuPear.Buy();
                        produceBottom();
                        TimeUnit.SECONDS.sleep(1);
                        produceTop();
                        menuPear.Use();
                        produceBottom();
                    }

                default: tryAgainTxt();
        
        }    
    } 
    
    public static void withdrawalBankExit() throws InterruptedException {        //GÖR OM
        int walletBalance = wallet.getWalletBalance();
        while (bankBalance > 0) {
            if (bankBalance >= 100) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 100) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 100;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 50 && bankBalance > 100) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 50) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 50;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 20 && bankBalance > 50) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 20) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 20;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else  if (bankBalance >= 10 && bankBalance > 20) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 10) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 10;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 5 && bankBalance > 10) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 5) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 5;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 1 && bankBalance > 5) {
                for (Moneys i: wallet.getWallet()) {
                    if (i.value == 1) {
                        i.setAmt(i.getAmt() + 1);
                        bankBalance -= 1;
                        withdrawalText(i);
                        wallet.setWalletBalance(i.value);
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            }
        }
        
        clearScreen();
        produceLine();
        produceRow(" ");
        produceRow("You have now withdrawn " + walletBalance + " SEK in your wallet  ");
        produceRow(" ");
        produceRow("See you next time and enjoy your new products");
        produceRow(" ");
        produceLine();
    }    
        
    //Textfiler
    public static boolean areYouSure() {    
        clearScreen();
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                            Are you really sure, human??                            |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                        |                                           |");
        System.out.println("|          Press 1 to confirm            |             Press 0 to cancel             |");
        System.out.println("|                                        |                                           |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
    
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        boolean isSure = true;

        switch(input) {
            case 0 -> isSure = false;
            case 1 -> isSure = true;
            default -> System.out.println("Try again");
        }
        return isSure;
    }  //Klar
     

    public static void successTxt() throws InterruptedException {
        clearScreen();
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
        System.out.println("|                            vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                                     SUCCESS!!!                                     |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                Wait 3 seconds to exit                              |");
        System.out.println("|------------------------------------------------------------------------------------|");
        TimeUnit.SECONDS.sleep(3);
    }

    public static void balanceShow(int bankBalance) {
        String printLine = "|                                                                                     |";
        int count = -2;
        int balanceCount = String.valueOf("Balance: " + bankBalance).length();
        String balance = "";
        
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        
        balance += "|";
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            balance += " ";
        }
        balance += ("Balance: " + String.valueOf(bankBalance));
        for (int i = 0; i < (count - balanceCount)/2; i++){
            balance += " ";
        }
        balance += "|";
        System.out.println(balance);
    }
    
    public static void walletShow(int walletBalance) {
        String printLine = "|                                                                                     |";
        int count = -2;
        int balanceCount = String.valueOf("You have : " + String.valueOf(walletBalance) + "SEK in your wallet!").length();
        String balance = "";
        
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        
        balance += "|";
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            balance += " ";
        }
        balance += ("You have : " + String.valueOf(walletBalance) + "SEK in your wallet!");
        for (int i = 0; i < (count - balanceCount)/2; i++){
            balance += " ";
        }
        balance += "|";
        System.out.println(balance);
    }

    public static void checkBalanceTxt(int bankBalance) {
        clearScreen();
        String printLine = "|                                                                                    |";
        int count = -2;
        int balanceCount = String.valueOf(bankBalance).length();
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
        System.out.println("|                         Bank of vicJaq1337s next level e-store                     |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                               Your current balance is:                             |");
        System.out.print("|");
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            System.out.print(" ");
        }
        System.out.print(bankBalance);
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                 Press 0 to go back                                 |");
        System.out.println("|------------------------------------------------------------------------------------|");
    }

    public static void tryAgainTxt() throws InterruptedException {
        clearScreen();
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
        System.out.println("|                            vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                                   TRY AGAIN!!                                      |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                Wait 3 seconds to exit                              |");
        System.out.println("|------------------------------------------------------------------------------------|");
        TimeUnit.SECONDS.sleep(3);
    }
    
    public static void produceLine() {
        System.out.println("|--------------------------------------------------------------------------------------|");
    }
    
    public static void produceRow(String input) {
        String printLine;
        printLine = "|--------------------------------------------------------------------------------------|";
        int count = -2;
        int stringCount =  String.valueOf(input).length();
                
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        
        System.out.print("|");
        for (int i = 0; i < ((count - stringCount)/2); i++){
            System.out.print(" ");
        }
        System.out.print(input);
        if (stringCount% 2 == 0) {
            for (int i = 0; i < ((count - stringCount)/2); i++){
                System.out.print(" ");
            }
            System.out.println("|");
        } else {
            for (int i = -1; i < ((count - stringCount)/2); i++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
        
    }
    
    public static void clearScreen() {   // Metod för att rensa loggen
        System.out.print("\033[H\033[2J");   
        System.out.flush();   
   }
    
    public static void produceTop() {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("vicJaq1337s next level e-store");
        produceRow("");
        produceLine();
    }
    
    public static void produceBankTop() {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("Bank of vicJaq1337s next level e-store");
        produceRow("");
        produceLine();
        produceRow("");
    }
    
    public static void produceBottom() {
        produceRow("");
        produceLine();
        produceRow("Press 0 to go back");
        produceLine();
    }
    
    public static void depositBankText() {
        clearScreen();
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); 
        System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
        walletShow(walletBalance); // Hämtar hur mycket pengar användaren har i plånboken
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                            Its time for you to deposit!                            |");
        System.out.println("|           Please enter the amount you would like to add to your balance            |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                 Press 0 to go back                                 |");
        System.out.println("|------------------------------------------------------------------------------------|");

    }
    
    public static void withdrawalBankText(){
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("Bank of vicJaq1337s next level e-store");
        walletShow(bankBalance); // Hämtar hur mycket pengar användaren har i plånboken
        produceRow("");
        produceLine();
        produceRow("");
        produceRow("Withdrawal");
        produceRow("Please enter the amount you would like to remove from your account");
        produceBottom();
    }
    
    public static void depositText(Moneys i) {
        produceLine();
        produceRow("");
        produceRow("You have put in: " + i.value + " SEK" + " ");
        produceRow("");
        produceLine();
    }
    
    public static void withdrawalText(Moneys i) {
        produceLine();
        produceRow("");
        Menu.produceRow("You have recieved: " + i.value + " SEK" + " ");
        produceRow("");
        produceLine();
    }


    @SuppressWarnings("fallthrough")
   
    /**
     * @return the bankBalance
     */
    public static int getBankBalance() {
        return bankBalance;
    }

    /**
     * @param aBankBalance the bankBalance to set
     */
    public static void setBankBalance(int aBankBalance) {
        bankBalance = aBankBalance;
    }

    /**
     * @return the pear
     */
    public static Paron getPear() {
        return pear;
    }

    /**
     * @param aPear the pear to set
     */
    public static void setPear(Paron aPear) {
        pear = aPear;
    }

    /**
     * @return the massage
     */
    public static Massage getMassage() {
        return massage;
    }

    /**
     * @param aMassage the massage to set
     */
    public static void setMassage(Massage aMassage) {
        massage = aMassage;
    }

    /**
     * @return the wallet
     */
    public static Wallet getThisWallet() {
        return wallet;
    }

    /**
     * @param aWallet the wallet to set
     */
    public static void setWallet(Wallet aWallet) {
        wallet = aWallet;
    }
}
    












