/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import java.util.ArrayList;
import java.util.Iterator;
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
    private int bankBalance, walletBalance;     //Saldo i kiosken och i plånboken
    public ArrayList<Moneys> wallet;    //Arraylist för min klass Moneys (derived från Money)
    public Paron pear;      //Min första produkt
    public Apple apple;     //Min andra produkt

    //Konstruktor
    public Menu() {  //När jag initierar objektet vill jag att den ska vara tom på pengar
        wallet = new ArrayList<>();
        walletBalance = 0;
        bankBalance = 0;
        pear = new Paron();
        apple = new Apple();

    }
    public static void main(String[] args) {
        // TODO code application logic here   
        Menu menu = new Menu();
        menu.fillWallet(10);  //fyller på min plånbok med 10 av varje valör
        menu.startMenu();   //Startar användarmenyn
        

    }    
        
        

    public void startMenu() {       // Första sidan av menyn där man kan välja om man vill handla produkter eller sätta in pengar i automaten
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
                        withdrawalBankExit();
                        break;
                    }
                case 1:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Öppnar banken
                        openBank();
                        break;
                    }
                case 2:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Öppnar affären
                        openShop();
                        break;
                    }
                    
                default: System.out.println("Enter a valid number");
                }
            }  
        } 
    
    public void openBank() {  //Startsida för banken. Samma logik här som tidigare
        boolean waitForInp = true; 
        while(waitForInp) {
            for (int i = 0; i < 50; ++i) {System.out.println();} 
            System.out.println("|------------------------------------------------------------------------------------|");
            balanceShow();  // Hämtar en funktion som printar ut saldo.
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
                case 0:
                    boolean areYouSure = areYouSure();
                    if (areYouSure) {
                        //Avslutar och går tillbaka till startsidan
                        waitForInp = false;  
                        }
                        break;
                case 1:
                    //Sätter in pengar 
                    depositBank();
                    break;
                case 2:
                    //Tar ut pengar
                    withdrawalBank();
                    break;
                case 3:
                    //Kollar saldot 
                    checkBalance();
                    break;
                default: System.out.println("Enter a valid number");
                }
            }
    } 
    
    public void openShop() {  //Startsida för affären. Samma logik här som tidigare startsidor
        for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            balanceShow();
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
                    productInfo(this.apple); 
                    break;
                    
                case 2:  // hämtar en funktion för att visa information om varan "Pear"
                    productInfo(this.pear);
                    break;
                           
                case 3: // Hade tänkt att använda en tredje vara men fick det inte att funka så lämna det så här
                    produceTop();  // hämtar en funktion för att producera överdelen av meddelanden
                    produceRow("Exclusive area! "); //hämtar en funktion för att producera en del av meddelandet med text
                    produceRow("");
                    produceRow("Come back when you have the fame that you need! ");
                    produceBottom(); // hämtar en funktion för att producera nedre delen av meddelandet
                    TimeUnit.SECONDS.sleep(3);  // stannar konsolen i 3 sekunder innan den kommer tillbaka
                    break;
                   
                      
                default: System.out.println("Enter a valid number");
            }
            
    } 
    


    public void depositBank() {  //Funktion för sätta in pengar på sitt konto
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); 
            System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
            walletShow(); // Hämtar hur mycket pengar användaren har i plånboken
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
            Scanner scan = new Scanner(System.in);  //Scanner för att mata in belopp
            int amt = scan.nextInt();   //Skannar efter belopp
            boolean isSure = areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.walletBalance) < amt) {
                    tryAgainTxt();
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) {
                        if (tempWallet >= 100) {
                            for (Moneys i: wallet) {
                             if (i.value == 100) {
                                i.amt -= 1;
                                tempWallet -= 100;
                                this.bankBalance += 100;
                                System.out.println("");                            
                                System.out.println("|------------------------------------------------------------------------------------|");
                                System.out.println("|                                                                                    |");
                                produceRow("You have put in " + i.value + " SEK" + " ");
                                System.out.println("|                                                                                    |");
                                System.out.println("|------------------------------------------------------------------------------------|");
                                TimeUnit.SECONDS.sleep(1);

                            }                 
                        }
                        } else if (tempWallet >= 50 && tempWallet < 100) {
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt -= 1;
                                    tempWallet -= 50;
                                    this.bankBalance += 50;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                 
                            }
                        } else if (tempWallet >= 20 && tempWallet < 50) {
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt -= 1;
                                    tempWallet -= 20;
                                    this.bankBalance += 20;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            }
                        } else if (tempWallet >= 10 && tempWallet < 20) {
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt -= 1;
                                    tempWallet -= 10;
                                    this.bankBalance += 10;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    tempWallet -= 5;
                                    this.bankBalance += 5;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have put in " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);

                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt -= 1;
                                    tempWallet -= 1; 
                                    this.bankBalance += 1;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have put in " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                    
                                }
                            }
                        }
                        
                        
                    }
                TimeUnit.SECONDS.sleep(1);
                successTxt();   
                walletBalance = 0;
                wallet.forEach((Moneys i) -> {
                walletBalance += (i.value * i.amt);
                        });
                waitForInp = false;
                    
                }
            }
        }
    }

    public void withdrawalBank() {
                boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); 
            System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
            balanceShow();
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
            Scanner scan = new Scanner(System.in);  //Scanner för att mata in belopp
            int amt = scan.nextInt();   //Skannar efter belopp
            boolean isSure = areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.bankBalance) < amt) {
                    tryAgainTxt();
                } else { //else if statement för att sätta in pengar 
                    while (bankBalance > 0) {
                        if (amt >= 100) {
                            for (Moneys i: wallet) {
                             if (i.value == 100) {
                                i.amt += 1;
                                amt -= 100;
                                this.bankBalance -= 100;
                                System.out.println("");                            
                                System.out.println("|------------------------------------------------------------------------------------|");
                                System.out.println("|                                                                                    |");
                                produceRow("You have recieved " + i.value + " SEK" + " ");
                                System.out.println("|                                                                                    |");
                                System.out.println("|------------------------------------------------------------------------------------|");
                                TimeUnit.SECONDS.sleep(1);

                            }                 
                        }
                        } else if (amt >= 50 && amt < 100) {
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt -= 1;
                                    amt -= 50;
                                    this.bankBalance -= 50;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                 
                            }
                        } else if (amt >= 20 && amt < 50) {
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt -= 1;
                                    amt -= 20;
                                    this.bankBalance -= 20;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            }
                        } else if (amt >= 10 && amt < 20) {
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt -= 1;
                                    amt -= 10;
                                    this.bankBalance -= 10;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                  
                            }
                        } else if (amt >= 5 && amt < 10) {
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    this.bankBalance += 5;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);

                                }
                            
                            }
                        } else if (amt >=1 && amt <5) {
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt -= 1;
                                    this.bankBalance += 1;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                    
                                }
                            }
                        }
                        
                        
                    }
                TimeUnit.SECONDS.sleep(1);
                successTxt();   
                walletBalance = 0;
                wallet.forEach((Moneys i) -> {
                walletBalance += (i.value * i.amt);
                        });
                waitForInp = false;
                    
                }
            }
        }
    }
    
    
    public void withdrawalBankExit() {        
        while (bankBalance > 0) {
            if (bankBalance >= 100) {
                for (Moneys i: wallet) {
                    if (i.value == 100) {
                        i.amt += 1;
                        this.bankBalance -= 100;
                        System.out.println("");                            
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 50 && bankBalance < 100) {
                for (Moneys i: wallet) {
                    if (i.value == 50) {
                        i.amt -= 1;
                        this.bankBalance -= 50;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }                 
                }
            } else if (bankBalance >= 20 && bankBalance < 50) {
                for (Moneys i: wallet) {
                    if (i.value == 20) {
                        i.amt -= 1;
                        this.bankBalance -= 20;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } else if (bankBalance >= 10 && bankBalance < 20) {
                for (Moneys i: wallet) {
                    if (i.value == 10) {
                        i.amt -= 1;
                        this.bankBalance -= 10;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }                  
                }
            } else if (bankBalance >= 5 && bankBalance < 10) {
                for (Moneys i: wallet) {
                    if (i.value == 5) {
                        i.amt -= 1;
                        this.bankBalance += 5;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } else if (bankBalance >=1 && bankBalance <5) {
                for (Moneys i: wallet) {
                    if (i.value == 1) {
                        i.amt -= 1;
                        this.bankBalance += 1;
                        System.out.println("");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        System.out.println("|                                                                                    |");
                        produceRow("You have recieved " + i.value + " SEK" + " ");
                        System.out.println("|                                                                                    |");
                        System.out.println("|------------------------------------------------------------------------------------|");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            }
        }
        walletBalance = 0;
        wallet.forEach((Moneys i) -> {
        walletBalance += (i.value * i.amt); });
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        produceRow(" You now have " + walletBalance + " SEK in your wallet  "+ " ");
        produceRow("");
        produceRow("See you next time!!!!" + " ")
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
    }
        
    
    public void checkBalance() {
        checkBalanceTxt();
        boolean waitForInp = true;
        Scanner scan = new Scanner(System.in);
        int menuChoice = scan.nextInt();
        while (waitForInp) {
            int exit = menuChoice;        
            if (exit == 0) {
            waitForInp = false;
            }
        }
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
    
    
    //Textfiler
    public boolean areYouSure() {    
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
     

    public void successTxt() {
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



    public void balanceShow() {
        String printLine = "|                                                                                     |";
        int count = -2;
        int balanceCount = String.valueOf("Balance: " + this.bankBalance).length();
        String balance = "";
        
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        
        balance += "|";
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            balance += " ";
        }
        balance += ("Balance: " + String.valueOf(this.bankBalance));
        for (int i = 0; i < (count - balanceCount)/2; i++){
            balance += " ";
        }
        balance += "|";
        System.out.println(balance);
    }
    
    public void walletShow() {
        String printLine = "|                                                                                     |";
        int count = -2;
        int balanceCount = String.valueOf("You have : " + String.valueOf(this.walletBalance) + "SEK in your wallet!").length();
        String balance = "";
        
        for (int i = 0; i < printLine.length(); i++) {
            count++;
        }
        
        balance += "|";
        for (int i = 0; i < ((count - balanceCount)/2); i++){
            balance += " ";
        }
        balance += ("You have : " + String.valueOf(this.walletBalance) + "SEK in your wallet!");
        for (int i = 0; i < (count - balanceCount)/2; i++){
            balance += " ";
        }
        balance += "|";
        System.out.println(balance);
    }

    public void checkBalanceTxt() {
        for (int i = 0; i < 50; ++i) {System.out.println();}
        String printLine = "|                                                                                    |";
        int count = -2;
        int balanceCount = String.valueOf(this.bankBalance).length();
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
        System.out.print(this.bankBalance);
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

    public void tryAgainTxt() {
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
    
    public void produceRow(String input) {
        String printLine = "|                                                                                    |";
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
    
    
    
    public void produceTop() {

        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                            vicJaq1337s next level e-store                          |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        
    }
    
    public void produceBottom() {
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                 Press 0 to go back                                 |");
        System.out.println("|------------------------------------------------------------------------------------|");
    }




    private void productInfo(Apple apple) {
        
        boolean waitForInp = true;
        while (waitForInp) {
            Scanner scan = new Scanner(System.in)
            produceTop();
            produceRow("Apple!");
            for (Iterator<String> it = apple.descriptionString.iterator(); it.hasNext();) {
                String e = it.next();
                produceRow(e + " ");
            }
            produceRow("  Category: " + String.valueOf(apple.type));
            produceRow(" Price: " + String.valueOf(apple.cost));
            produceRow("  ");
            produceRow(" Press 1 to buy!");
            produceBottom(); 

        int menuChoice = scan.nextInt();
        
        if (menuChoice==0) {
            boolean isSure = areYouSure();
                if (isSure) {
                    openShop();
                }
        } else if (menuChoice==1) {
                boolean checkSure = areYouSure();
                if (checkSure) {
                waitForInp = false;
                if (bankBalance > apple.cost) {
                bankBalance -= apple.cost;
                produceTop();
                produceRow("Buy Apple!");
                for (Iterator<String> it = apple.buyString.iterator(); it.hasNext();) {
                    String e = it.next();
                    produceRow(e + " ");
                }
                produceRow("Press 1 to use now!");
                produceBottom();
                menuChoice = scan.nextInt();
                if (menuChoice == 1) {
                        produceTop();
                        produceRow("Eat Apple!");
                        for (Iterator<String> it = apple.useString.iterator(); it.hasNext();) {
                            String e = it.next();
                            produceRow(e + " ");
                        }
                        produceBottom();
                        TimeUnit.SECONDS.sleep(3);
                        
                } else if (menuChoice == 0) {
                    openShop();
                }
                        
                    
                } else if (bankBalance < apple.cost) {
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
                    openShop();
                    
                }
                    }
        }
    }
 }
    
 private void productInfo(Paron paron) {
        
        boolean waitForInp = true;
        while (waitForInp) {
            Scanner scan = new Scanner(System.in)
            produceTop();
            produceRow("Pear!");
            for (Iterator<String> it = paron.descriptionString.iterator(); it.hasNext();) {
                String e = it.next();
                produceRow(e + " ");
            }
            produceRow("Category: " + String.valueOf(paron.type));
            produceRow("Price: " + String.valueOf(paron.cost));
            produceRow(" ");
            produceRow("Press 1 to buy!");
            produceBottom(); 

        int menuChoice = scan.nextInt();
        
        if (menuChoice==0) {
            boolean isSure = areYouSure();
                if (isSure) {
                    openShop();
                }
        } else if (menuChoice==1) {
                boolean isSure = areYouSure();
                if (isSure) {
                waitForInp = false;
                if (bankBalance > paron.cost) {
                bankBalance -= paron.cost;
                produceTop();
                produceRow("Buy a Pear!");
                for (Iterator<String> it = paron.buyString.iterator(); it.hasNext();) {
                    String e = it.next();
                    produceRow(e + " ");
                }
                produceRow("Press 1 to use now!");
                produceBottom();
                menuChoice = scan.nextInt();
                if (menuChoice == 1) {
                        produceTop();
                        produceRow("Eat your Pear!");
                        for (Iterator<String> it = paron.useString.iterator(); it.hasNext();) {
                            String e = it.next();
                            produceRow(e + " ");
                        }
                        produceBottom();
                        TimeUnit.SECONDS.sleep(3);
                        
                } else if (menuChoice == 0) {
                    openShop();
                }
                        
                    
                } else if (bankBalance < paron.cost) {
                    for (int i = 0; i < 50; ++i) {System.out.println();}
                    produceTop();
                    produceRow("ERROR!!!");
                    produceRow("");
                    produceRow("You don't have enough money");
                    System.out.println("|                                                                                    |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    System.out.println("|                             Wait 3 seconds to return                               |");
                    System.out.println("|------------------------------------------------------------------------------------|");
                    TimeUnit.SECONDS.sleep(3);
                    openShop();
                    
                }
                    }
        }
    }
 }



}













