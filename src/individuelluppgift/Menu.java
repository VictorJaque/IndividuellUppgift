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
    //Konstruktor 
    //används aldrig men måste väl vara med?
    public Menu(int value) {
        super(value);
    }
    
    
    //Min main metod som skapar en plånbok. adderar 10 av varje valör och som 
    //används för att starta menyn!
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here   
        Wallet userWallet = new Wallet(0);
        userWallet.fillWallet(10);
        startMenu(userWallet);   //Startar användarmenyn
    }    
        
        
    // Första sidan av menyn där man kan välja om man vill handla produkter eller gå in på "banken"
    @SuppressWarnings("fallthrough")
    public static void startMenu(Wallet userWallet) throws InterruptedException {       
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
                        //Avslutar programmet och tar ut återstående pengar
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
                    //Felmeddelande vid felaktikg inmatning
                default: tryAgainTxt();
                }
            }  
        } 
    
    public static Wallet openBank(Wallet userWallet) throws InterruptedException {  //Startsida för banken. Samma logik här startMenu(userWallet)
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
            produceRow("4. [HIDDEN]  ");
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
                    //Startar en ny instans av Massage som ger användaren erbjudande att köpa 
                    Massage itemMassage = new Massage(100, "Service", userWallet.getBankBalance());
                    itemMassage.Description();
                    userWallet.setBankBalance(itemMassage.getBankBalance());
                    break;
                case 2: 
                    //Startar en ny instans av Pear som ger användaren erbjudande att köpa 
                    Pear itemPear = new Pear(7, "Food", userWallet.getBankBalance());
                    itemPear.Description();
                    userWallet.setBankBalance(itemPear.getBankBalance());
                    break;
                case 3: 
                    //Startar en ny instans av Car som ger användaren erbjudande att köpa 
                    Car itemCar = new Car(500, "Vehicle", userWallet.getBankBalance());
                    itemCar.Description();
                    userWallet.setBankBalance(itemCar.getBankBalance());
                    break;
                case 4:
                    //Startar en ny instans av Hitman som ger användaren erbjudande att köpa
                    Hitman itemHitman = new Hitman(10000, "Service", userWallet.getBankBalance());
                    itemHitman.Description();
                    userWallet.setBankBalance(itemHitman.getBankBalance());
                default: tryAgainTxt();
            }
        }
    }
     
    
       
    /* Nedan följer endast metoder för att skapa olika outputs
    de flesta använder sig av simpla System.out metoder.
    De metoder som har parameter använder sig av olika ekvationer */
    
    //Textmetod som validerar användarens svar. Returnerar en Boolean på sant eller falskti
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
    }  //Textfil som validerar användarens svar. Returnerar en Boolean på sant eller falskti
    
    //Textmetod för när man har lyckat sätta in/ta ut pengar
    public static void successTxt() throws InterruptedException {
        clearScreen();
        System.out.println("|--------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                      |");
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
    
    //Textmetod för att skriva ut vad man har på sitt saldo
    public static void balanceShow(int bankBalance) {
        String printLine = "|                                                                                     |"; //tar in hur lång en rad ska vara
        int count = -2;  // lokal integer som ska räkna ut hur många tecken en rad behöver utan "|" - därav minus 2
        int balanceCount = String.valueOf("Balance: " + bankBalance).length();  //konverterar längden på önskad utskrift till siffror
        String balance = "";  //string variabel som i slutändan kommer vara det som skrivs ut
        
        for (int i = 0; i < printLine.length(); i++) {  // för loop för att räkna ut längden på prinLine.
            count++;
        }
        
        balance += "|";   //Lägger till start-symbolen
        for (int i = 0; i < ((count - balanceCount)/2); i++){ //sen en For-loop som körs lika många gånger som hälften av count-balanceCount 
            balance += " ";  //för varje gång den körs printar den ut ett mellanslag
        }
        balance += ("Balance: " + String.valueOf(bankBalance));  //sen printar den ut det som ska stå
        if (balanceCount %2 == 0) {  //if sats som ser till att de blir rätt antal mellanslag beroende på om det är jämt delbart med 2 eller inte.
            for (int i = 0; i < (count - balanceCount)/2; i++){
                balance += " ";
            }
            balance += "|";
            System.out.println(balance);
        } else {
            for (int i = -1; i < (count - balanceCount)/2; i++){ //ifall det inte är jämt delbart ska den skriva ut ett extra mellanslag
                balance += " ";
            }
            balance += "|";
            System.out.println(balance);              
        }  
        
    }
    
    //Textmetod för att skriva ut vad man har i plånboken. Logiken är likadan som balanceShow(bankBalance)
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

    //Textmetod för att kolla sitt saldo i bankmenyn.
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

    //Textmetod för när man har misslyckats sätta in/ta ut pengar.
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
    
    //Textmetod för att skapa en linje i konsolen 
    public static void produceLine() {
        System.out.println("|--------------------------------------------------------------------------------------|");
    }
    
    //Parameteren tar in vad som ska skrivas
    //Samma logik som i balanceShow(bankBalance) fast man använder sig av en String istället för Int
    public static void produceRow(String input) {
        //Lokala variabler
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
    
    // Metod för att rensa konsolen
    public static void clearScreen() {   // Metod för att rensa loggen
        for (int i = 0 ; i < 50; i++) {System.out.println("");} //For-Loop som skriver ut 50 tomma rader  
   }
    
    //Textmetod för att producera "headern" i shoppen
    public static void produceTop(Wallet userWallet) {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("vicJaq1337s next level e-store");
        produceRow("");
        walletShow(Wallet.getBankBalance());
        produceLine();
    }
    //Textmetod för att producera "headern" i banken.
    public static void produceBankTop() {
        clearScreen();
        produceLine();
        produceRow("");
        produceRow("Bank of vicJaq1337s next level e-store");
        produceRow("");
        produceLine();
        produceRow("");
    }
    
    //Textmetod för att producera sidfoten i konsolen när användaren kan trycka 0 för att gå tillbaka
    public static void produceBottom() {
        produceRow("");
        produceLine();
        produceRow("Press 0 to go back");
        produceLine();
    }
    
    //Textfil för metoden att sätta in pengar i klassen Wallet
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
    //Textfil för metoden att ta ut pengar i klassen Wallet
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
    //Textfil för att användaren ska se vad den sätter in
    public static void depositText(int i) {
        produceLine();
        produceRow("");
        produceRow("You have put in: " + i + " SEK" + " ");
        produceRow("");
        produceLine();
    }
    //Textfil för att användaren ska se vad den tar ut
    public static void withdrawalText(int i) {
        produceLine();
        produceRow("");
        Menu.produceRow("You have recieved: " + i + " SEK" + " ");
        produceRow("");
        produceLine();
    }

   
}
    












