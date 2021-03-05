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

  
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here   
        Wallet userWallet = new Wallet(0);
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
                        userWallet.withdrawalBankExit();
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
    
    public static Wallet openBank(Wallet userWallet) throws InterruptedException {  //Startsida för banken. Samma logik här som tidigar
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
                case 0:
                    boolean areYouSure = areYouSure();
                    if (areYouSure) {
                        //Avslutar och går tillbaka till startsidan
                        waitForInp = false;
                        }break;
                case 1: //Sätter in pengar 
                    userWallet.depositBank();
                    break;
                case 2: //Tar ut pengar
                    userWallet.withdrawalBank();
                    break;
                case 3: //Kollar saldot 
                    userWallet.checkBalance();
                    break;
                default: 
                    tryAgainTxt();
                }
            }
        return userWallet;
    } 
    
    @SuppressWarnings("fallthrough")
    public static void openShop(Wallet userWallet) throws InterruptedException {  //Startsida för affären. Samma logik här som tidigare startsidor
        boolean waitForInp = true; 
        while(waitForInp) {
            clearScreen();
            produceTop(userWallet);
            produceRow("Select one of the following choices:");
            produceRow("1. Massage   ");
            produceRow("2. Pear      ");
            produceRow("3. Car       ");
            produceRow("");
            produceBottom();
       
            Scanner scan = new Scanner(System.in);
            int menuChoice = scan.nextInt();
            switch(menuChoice) {
                case 0:
                    boolean areYouSure = areYouSure(); //Funktion som frågar användaren om deen är säker
                    if (areYouSure) {
                        //Avslutar programmet
                        waitForInp = false;
                        break;
                    }
                case 1: 
                    Massage itemMassage = new Massage(100, "Service", userWallet.getBankBalance());
                    itemMassage.Description();
                    userWallet.setBankBalance(itemMassage.getBankBalance());
                    break;
                case 2: //Tar ut pengar
                    //Pear itemPear = new Pear(7, "Food");
                    //itemPear.Description();
                    break;
                case 3: 
                    //Car itemCar = new Car(500, "Vehicle");
                    //itemCar.Description();
                    break;
                case 4:
                    //Hitman itemHitman = new Hitman(10000, "Service");
                    //itemHitman.Description();
                default: tryAgainTxt();
            }
        }
    }
     
    
       
        
    //Textfiler
    public static boolean areYouSure() throws InterruptedException {    
        clearScreen();
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                     |");
        System.out.println("|                            Are you really sure, human??                             |");
        System.out.println("|                                                                                     |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                        |                                            |");
        System.out.println("|          Press 1 to confirm            |             Press 0 to cancel              |");
        System.out.println("|                                        |                                            |");
        System.out.println("|-------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                     |");
        System.out.println("|                                                                                     |");
        System.out.println("|-------------------------------------------------------------------------------------|");
    
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        boolean isSure = true;

        switch(input) {
            case 0: 
                isSure = false;
                break;
            case 1:
                isSure = true;
                break;
            default : tryAgainTxt();
        }
        return isSure;
    }  //Klar
     

    public static void successTxt() throws InterruptedException {
        clearScreen();
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                      |"); //21 tabs 1 mellanslag
        System.out.println("|                              vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                      |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                      |");
        System.out.println("|                                       SUCCESS!!!                                     |");
        System.out.println("|                                                                                      |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                  Wait 2 seconds to exit                              |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        TimeUnit.SECONDS.sleep(2);
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
        if (balanceCount %2 == 0) {
            for (int i = 0; i < (count - balanceCount)/2; i++){
                balance += " ";
            }
            balance += "|";
            System.out.println(balance);
        } else {
            for (int i = -1; i < (count - balanceCount)/2; i++){
                balance += " ";
            }
            balance += "|";
            System.out.println(balance);              
        }  
        
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
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                      |"); //21 tabs 1 mellanslag
        System.out.println("|                              vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                      |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                      |");
        System.out.println("|                                     TRY AGAIN!!                                      |");
        System.out.println("|                                                                                      |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                 Wait 2 seconds to exit                               |");
        System.out.println("|--------------------------------------------------------------------------------------|");
        TimeUnit.SECONDS.sleep(2);
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
        for (int i = 0 ; i < 50; i++) {System.out.println("");}   
   }
    
    public static void produceTop(Wallet userWallet) {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("vicJaq1337s next level e-store");
        produceRow("");
        walletShow(Wallet.getBankBalance());
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
        walletShow(Wallet.getWalletBalance()); // Hämtar hur mycket pengar användaren har i plånboken
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
        walletShow(getBankBalance()); // Hämtar hur mycket pengar användaren har i plånboken
        produceRow("");
        produceLine();
        produceRow("");
        produceRow("Withdrawal");
        produceRow("Please enter the amount you would like to remove from your account");
        produceBottom();
    }
    
    public static void depositText(int i) {
        produceLine();
        produceRow("");
        produceRow("You have put in: " + i + " SEK" + " ");
        produceRow("");
        produceLine();
    }
    
    public static void withdrawalText(int i) {
        produceLine();
        produceRow("");
        Menu.produceRow("You have recieved: " + i + " SEK" + " ");
        produceRow("");
        produceLine();
    }

    public Menu(int value) {
        super(value);
    }
}
    












