/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * //Liten kommentar. Jag har fortfarande 1 bugg som jag inte vill ha
 * //men jag har nästlat in mig och valt allt lämna den. När man vill
 * //lämna programmet så måste man bekräfta fler gånger än en.
 * //Jag kan dock ha löst den nu när jag skrivit kommentarer
 * 
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Menu {
    //Attribut för "kiosken". en int variabel för fysisk plånbok, en för kiosk
    //samt en array list för min klass Moneys (derived från Money)
    public static int bankBalance; //Saldo för kiosk
    public static Paron pear;      //Min första produkt
    public static Massage massage;     //Min andra produkt

    //Konstruktor
    public Menu() {  //När jag initierar objektet vill jag att den ska vara tom på pengar
        bankBalance = 0;
        pear = new Paron();
        massage = new Massage();

    }
    public static void main(String[] args) {
        // TODO code application logic here   
        Wallet userWallet = new Wallet();
        userWallet.fillWallet(10);
        startMenu(userWallet);   //Startar användarmenyn
        

    }    
        
        

    public static void startMenu(Wallet userWallet) throws InterruptedException {       // Första sidan av menyn där man kan välja om man vill handla produkter eller sätta in pengar i automaten
        Wallet bankWallet = new Wallet();
        boolean startMenu = true;   //använder en lokal boolean i en while loop som producerar ny text efter varje input från användaren ifall den inte skulle mata in rätt
        Scanner scan = new Scanner(System.in);  //Initierar en scanner för att användaren ska kunna mata in sitt val
        while (startMenu) {
            for (int i = 0; i < 50; ++i) {System.out.println();} // for loop för att "rensa" konsolen
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                              Greetings simple human!                               |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                       This is vicJaq1337s next level e-store                       |");
            System.out.println("|                               Super cool, right?                                   |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                        Select one of the following choices:                        |");
            System.out.println("|     1. Open Bank of vicJaq1337s next level e-store                                 |");
            System.out.println("|     2. Check out the best sortiment of the world in vicJaq1337s next level e-store |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                Press 0 to exit vicJaq1337s next level e-store now                  |");
            System.out.println("|------------------------------------------------------------------------------------|");
            int menuChoice = scan.nextInt();
            switch(menuChoice) { // Switch case för att komma in på de olika alternativen
                case 0:
                    boolean areYouSure = areYouSure(); //Funktion som frågar användaren om deen är säker
                    if (areYouSure) {
                        //Avslutar programmet
                        startMenu = false;
                        withdrawalBankExit(userWallet);
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
        Wallet wallet = userWallet;
        while(waitForInp) {
            for (int i = 0; i < 50; ++i) {System.out.println();} 
            System.out.println("|------------------------------------------------------------------------------------|");
            balanceShow(userWallet.bankBalance);  // Hämtar en funktion som printar ut saldo.
            System.out.println("|                  Welcome to Bank of vicJaq1337s next level e-store                 |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                        Select one of the following choices:                        |");
            System.out.println("|     1. Deposit money to current account                                            |");
            System.out.println("|     2. Withdrawal money from vicJaq1337s next level e-store                        |");
            System.out.println("|     3. Check Balance                                                               |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                  Press 0 to exit Bank of vicJaq1337 next level e-store             |");
            System.out.println("|------------------------------------------------------------------------------------|"); 
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
                    wallet.depositBank();
                case 2 -> //Tar ut pengar
                    wallet.withdrawalBank();
                case 3 -> //Kollar saldot 
                    wallet.checkBalance();
                default -> tryAgainTxt();
                }
            }
    } 
    
    public static void openShop(Wallet userWallet) throws InterruptedException {  //Startsida för affären. Samma logik här som tidigare startsidor
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        balanceShow(Wallet.bankBalance);
        System.out.println("|                      Welcome to vicJaq1337s next level e-store                     |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                        Select one of the following choices:                        |");
        System.out.println("|        1. Apple                       2. Pear                        3. [hidden]   |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        produceBottom();
       
        Scanner scan = new Scanner(System.in);
        int menuChoice = scan.nextInt();
        switch(menuChoice) {
            case 0: //avslutar den här sidan
                boolean areYouSure = areYouSure();
                if (areYouSure) {
                    break;
                }
                case 1:  // hämtar en funktion för att visa information om varan "Apple"
                    productInfoMassage(); 
                    break;
                    
                case 2:  // hämtar en funktion för att visa information om varan "Pear"
                    productInfoPear();
                    break;
                           
                case 3: // Hade tänkt att använda en tredje vara men fick det inte att funka så lämna det så här
                    produceTop();  // hämtar en funktion för att producera överdelen av meddelanden
                    produceRow("Exclusive area! "); //hämtar en funktion för att producera en del av meddelandet med text
                    produceRow("");
                    produceRow("Come back when you have the fame that you need! ");
                    produceBottom(); // hämtar en funktion för att producera nedre delen av meddelandet
                    TimeUnit.SECONDS.sleep(3);  // stannar konsolen i 3 sekunder innan den kommer tillbaka
                    break;
                   
                      
                default: tryAgainTxt();
            }
            
    } 
    
    public static void withdrawalBankExit(Wallet wallet) throws InterruptedException {        //Samma logik som att ta ut fast den inte producerar någon menytext
        int walletBalance = wallet.walletBalance;
        int walletBalance = wallet.bankBalance;
        while (wallet.bankBalance > 0) {
            if (wallet.bankBalance >= 100) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 100) {
                        i.amt += 1;
                        wallet.bankBalance -= 100;
                        System.out.println("");                            
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 100;
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (wallet.bankBalance >= 50 && wallet.bankBalance < 100) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 50) {
                        i.amt -= 1;
                        wallet.bankBalance -= 50;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 50;
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (wallet.bankBalance >= 20 && wallet.bankBalance < 50) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 20) {
                        i.amt -= 1;
                        wallet.bankBalance -= 20;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 20;
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } else if (wallet.bankBalance >= 10 && wallet.bankBalance < 20) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 10) {
                        i.amt -= 1;
                        wallet.bankBalance -= 10;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 10;
                        TimeUnit.SECONDS.sleep(1);
                    }                  
                }
            } else if (bankBalance >= 5 && bankBalance < 10) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 5) {
                        i.amt -= 1;
                        bankBalance -= 5;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 5;
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } else if (bankBalance >=1 && bankBalance <5) {
                for (Moneys i: wallet.wallet) {
                    if (i.value == 1) {
                        i.amt -= 1;
                        bankBalance -= 1;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        walletBalance += 1;
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            }
        }
        
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        produceRow(" You have now withdrawn " + walletBalance + " SEK in your wallet  "+ " ");
        produceRow("");
        produceRow("See you next time!!!!" + " ");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
    }    
        
    //Textfiler
    public static boolean areYouSure() {    
        for (int i = 0; i < 50; ++i) System.out.println();
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
        for (int i = 0; i < 50; ++i) {System.out.println();}
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
        for (int i = 0; i < 50; ++i) {System.out.println();}
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
        for (int i = 0; i < 50; ++i) {System.out.println();}
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
    
    public static void produceRow(String input) {
        String printLine = "|                                                                                     |";
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
        for (int i = 0; i < ((count - stringCount)/2); i++){
            System.out.print(" ");
        }
        System.out.println("|");
        
    }
    
    public static void produceTop() {

        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                            vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        
    }
    
    public static void produceBottom() {
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                 Press 0 to go back                                 |");
        System.out.println("|------------------------------------------------------------------------------------|");
    }




    private static void productInfoMassage() throws InterruptedException {
        Massage massage = new Massage();
        boolean waitForInp = true;
        while (waitForInp) {
            Scanner scan = new Scanner(System.in);
            produceTop();
            produceRow("Massage from a true master");
            massage.descriptionString.forEach(e -> {
            produceRow(e + " ");
            });
            produceRow("  Category: " + String.valueOf(massage.type) + " ");
            produceRow(" Price: " + String.valueOf(massage.cost + " "));
            produceRow("  ");
            produceRow(" Press 1 to buy!");
            produceBottom(); 
        int menuChoice = scan.nextInt();
        switch(menuChoice) {
            case 0:
                if (areYouSure()) {
                    waitForInp = false;
                    break;
                } else {
                    
                }
            case 1: 
                boolean checkSure = areYouSure();
                if (checkSure) {
                waitForInp = false;
                if (this.bankBalance > massage.cost) {
                this.bankBalance -= massage.cost;
                produceTop();
                produceRow("Welcome to my studio, dont mind the cameras");
                massage.buyString.forEach(e -> {
                    produceRow(e + "  ");
                    });
                produceRow("Press 1 to use now!" + " ");
                produceBottom();
                menuChoice = scan.nextInt();
                if (menuChoice == 1) {
                        massage.useString.forEach(e -> {
                            for (int i = 0; i < 50; ++i) {System.out.println();}
                            produceTop();
                            produceRow("Enjoy the massage");
                            produceRow(e + "  ");
                            produceBottom();
                            TimeUnit.SECONDS.sleep(1);
                        });
                        produceBottom();
                        TimeUnit.SECONDS.sleep(3);
                        break;
                } else if (menuChoice == 0) {
                    break;
                    }
                } else if (bankBalance < massage.cost) {
                    for (int i = 0; i < 50; ++i) {System.out.println();}
                    produceTop();
                    produceRow("ERROR!!!");
                    produceRow("");
                    produceRow("You don't have enough money ");
                    System.out.println("|                                                                                    |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|                             Wait 3 seconds to return                               |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    TimeUnit.SECONDS.sleep(3);
                    break;
                    
                }
            }
            default: System.out.println("Enter a valid number");
        }
    }
 }
    
    private static void productInfoPear() throws InterruptedException {
        Paron paron = new Paron();
        boolean waitForInp = true;
        while (waitForInp) {
            Scanner scan = new Scanner(System.in);
            produceTop();
            produceRow("Pear!");
            paron.descriptionString.forEach(e -> {
            produceRow(e + " ");
            });
            produceRow("  Category: " + String.valueOf(paron.type) + " ");
            produceRow(" Price: " + String.valueOf(paron.cost + " "));
            produceRow("  ");
            produceRow(" Press 1 to buy!");
            produceBottom(); 
        int menuChoice = scan.nextInt();
        switch(menuChoice) {
            case 0:
                if (areYouSure()) {
                    waitForInp = false;
                    break;
                } else {
                    
                }
            case 1: 
                boolean checkSure = areYouSure();
                if (checkSure) {
                waitForInp = false;
                if (this.bankBalance > paron.cost) {
                this.bankBalance -= paron.cost;
                produceTop();
                produceRow("Buy a Pear!");
                paron.buyString.forEach(e -> {
                    produceRow(e + " ");
                    });
                produceRow("Press 1 to use now!");
                produceBottom();
                menuChoice = scan.nextInt();
                if (menuChoice == 1) {
                        produceTop();
                        produceRow("Eat your god damn Pear");
                        paron.useString.forEach(e -> {
                            produceRow(e + " ");
                        });
                        produceBottom();
                        TimeUnit.SECONDS.sleep(3);
                        break;
                } else if (menuChoice == 0) {
                    break;
                    }
                } else if (bankBalance < paron.cost) {
                    for (int i = 0; i < 50; ++i) {System.out.println();}
                    produceTop();
                    produceRow("ERROR!!!");
                    produceRow("");
                    produceRow("You don't have enough money ");
                    System.out.println("|                                                                                    |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|                             Wait 3 seconds to return                               |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    TimeUnit.SECONDS.sleep(3);
                    break;
                    
                }
            }
            default: System.out.println("Enter a valid number");
            }
        }
    }
}
    












