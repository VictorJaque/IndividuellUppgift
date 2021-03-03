/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuelluppgift;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Victor Jaque <victor.jaque.mte21lin@tucsweden.se>
 */
public class Wallet extends Menu {  //Klass som symboliserar en plånbok
    //Attribut
    public ArrayList<Moneys> wallet; //En arraylist av mina pengar
    public int walletBalance; //Ett saldo i int som baseras efter hur mycket pengar som finns i plånboken
    Scanner scan;
    
    
    //Konstruktor för en tom plånbok
    public Wallet() {
        super();
        wallet = new ArrayList<>();
        walletBalance = 0;
        scan = new Scanner(System.in);
    }
    
    
    //Metod för att fylla plånboken med alla valörer. Använder sig av metoder från Moneys Klassen.
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
    
    public void depositBank() throws InterruptedException {  //Funktion för sätta in pengar på sitt konto
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); 
            System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
            Menu.walletShow(walletBalance); // Hämtar hur mycket pengar användaren har i plånboken
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
            int amt = scan.nextInt();   //Skannar efter belopp
            boolean isSure = Menu.areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.walletBalance) < amt) {
                    Menu.tryAgainTxt();  //om man har för lite pengar i plånboken får man ett error meddelande
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) { //while loop som säger att så länge det finns pengar kvar att sätta in så ska den fortsätta
                        if (tempWallet >= 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: wallet) {  // for each loop för att kolla igenom listan med pengar
                             if (i.value == 100) {  // ser till att det är en 100-kr sedel som går in
                                i.amt -= 1; // ändrar antalet i plånboken
                                tempWallet -= 100;  //tar bort från det som ska matas in
                                bankBalance += 100;  //tar in det som matas in
                                System.out.println("");      // Skriver ut ett meddelande att den tagit emot pengarna                      
                                System.out.println("|------------------------------------------------------------------------------------|");
                                System.out.println("|                                                                                    |");
                                Menu.produceRow("You have put in " + i.value + " SEK" + " ");
                                System.out.println("|                                                                                    |");
                                System.out.println("|------------------------------------------------------------------------------------|");
                                TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se

                            }                 
                        }
                        } else if (tempWallet >= 50 && tempWallet < 100) {  //samma princip som tidigare fast för 50kr sedlar
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt -= 1;
                                    tempWallet -= 50;
                                    bankBalance += 50;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                 
                            }
                        } else if (tempWallet >= 20 && tempWallet < 50) { // samma princip fast för 20kr sedlar
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt -= 1;
                                    tempWallet -= 20;
                                    bankBalance += 20;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            }
                        } else if (tempWallet >= 10 && tempWallet < 20) {  // samma princip fast för 10krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt -= 1;
                                    tempWallet -= 10;
                                    bankBalance += 10;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have put in " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {  // Samma princip fast för 5krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    tempWallet -= 5;
                                    bankBalance += 5;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have put in " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);

                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {  //Samma princip fast för 1krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt -= 1;
                                    tempWallet -= 1; 
                                    bankBalance += 1;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have put in " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                    
                                }
                            }
                        }
                        
                        
                    }
                TimeUnit.SECONDS.sleep(1); 
                Menu.successTxt();   // funktion som visar att allt är klart 
                walletBalance = 0;  //nollställer plånbokssaldos
                wallet.forEach((Moneys i) -> {  //for each loop för att uppdatera saldot
                walletBalance += (i.value * i.amt);  // värdet av kronan gånger antalet
                        });
                waitForInp = false; //Stänger ner menyn
                    
                }
            }
        }
    }
    
    public void withdrawalBank() throws InterruptedException { //Meny för att ta ut pengar.  Logiken är likadan som för att ta ut, vissa ändringar för att optimera samt ändrat på operatorer för att minska istället för att öka och tvärtom
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); 
            System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
            Menu.walletShow(walletBalance); // Hämtar hur mycket pengar användaren har i plånboken
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                                      Withdrawal                                    |");
            System.out.println("|        Please enter the amount you would like to remove from your account          |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                 Press 0 to go back                                 |");
            System.out.println("|------------------------------------------------------------------------------------|");
            int amt = scan.nextInt();   //Skannar efter belopp
            boolean isSure = Menu.areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.walletBalance) < amt) {
                    Menu.tryAgainTxt();  //om man har för lite pengar i plånboken får man ett error meddelande
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) { //while loop som säger att så länge det finns pengar kvar att sätta in så ska den fortsätta
                        if (tempWallet >= 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: wallet) {  // for each loop för att kolla igenom listan med pengar
                             if (i.value == 100) {  // ser till att det är en 100-kr sedel som går in
                                i.amt += 1; // ändrar antalet i plånboken
                                tempWallet -= 100;  //tar bort från det som ska matas in
                                bankBalance -= 100;  //tar in det som matas in
                                System.out.println("");      // Skriver ut ett meddelande att den tagit emot pengarna                      
                                System.out.println("|------------------------------------------------------------------------------------|");
                                System.out.println("|                                                                                    |");
                                Menu.produceRow("You have recieved: " + i.value + " SEK" + " ");
                                System.out.println("|                                                                                    |");
                                System.out.println("|------------------------------------------------------------------------------------|");
                                TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se

                            }                 
                        }
                        } else if (tempWallet >= 50 && tempWallet < 100) {  //samma princip som tidigare fast för 50kr sedlar
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt += 1;
                                    tempWallet -= 50;
                                    bankBalance -= 50;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have recieved: " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                 
                            }
                        } else if (tempWallet >= 20 && tempWallet < 50) { // samma princip fast för 20kr sedlar
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt += 1;
                                    tempWallet -= 20;
                                    bankBalance -= 20;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have recieved: " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }
                            }
                        } else if (tempWallet >= 10 && tempWallet < 20) {  // samma princip fast för 10krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt += 1;
                                    tempWallet -= 10;
                                    bankBalance -= 10;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have recieved: " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {  // Samma princip fast för 5krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt += 1;
                                    tempWallet -= 5;
                                    bankBalance -= 5;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have recieved: " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);

                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {  //Samma princip fast för 1krs mynt
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt += 1;
                                    tempWallet -= 1; 
                                    bankBalance -= 1;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    Menu.produceRow("You have recieved: " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                    
                                }
                            }
                        }
                        
                        
                    }
                TimeUnit.SECONDS.sleep(1); 
                Menu.successTxt();   // funktion som visar att allt är klart 
                walletBalance = 0;  //nollställer plånbokssaldos
                wallet.forEach((Moneys i) -> {  //for each loop för att uppdatera saldot
                walletBalance += (i.value * i.amt);  // värdet av kronan gånger antalet
                        });
                waitForInp = false; //Stänger ner menyn
                    
                }
            }
        }
        
        
        /*boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); 
            System.out.println("|                       Bank of vicJaq1337s next level e-store                       |");
            Menu.balanceShow(this.bankBalance);
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                                    Withdraw money                                  |");
            System.out.println("|           Please enter the amount you would like to add to your balance            |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                 Press 0 to go back                                 |");
            System.out.println("|------------------------------------------------------------------------------------|");  
            int amt = scan.nextInt();   
            boolean isSure = Menu.areYouSure();         
            if (amt == 0) {  
                waitForInp = false;
            } else if (isSure) { 
                if ((bankBalance) < amt) {
                    Menu.tryAgainTxt();
                } else {  
                    int tempWallet = amt;
                    while (bankBalance > 0) {
                        if (tempWallet >= 100) {
                            for (Moneys i: wallet) {
                             if (i.value == 100) {
                                i.amt += 1;
                                tempWallet -= 100;
                                bankBalance -= 100;
                                System.out.println("");                            
                                System.out.println("|------------------------------------------------------------------------------------|");
                                System.out.println("|                                                                                    |");
                                produceRow("You have recieved " + i.value + " SEK" + " ");
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
                                    bankBalance -= 50;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
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
                                    bankBalance -= 20;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
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
                                    bankBalance -= 10;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    bankBalance += 5;
                                    System.out.println("");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    System.out.println("|                                                                                    |");
                                    produceRow("You have recieved " + i.value + " SEK" + " ");
                                    System.out.println("|                                                                                    |");
                                    System.out.println("|------------------------------------------------------------------------------------|");
                                    TimeUnit.SECONDS.sleep(1);

                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {
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
                Menu.successTxt();   // funktion som visar att allt är klart 
                walletBalance = 0;  //nollställer plånbokssaldos
                wallet.forEach((Moneys i) -> {  //for each loop för att uppdatera saldot
                walletBalance += (i.value * i.amt);  // värdet av kronan gånger antalet
                        });
                waitForInp = false; //Stänger ner menyn
                }
            }
        }*/
    }
    
    public void checkBalance() {
        checkBalanceTxt(Wallet.bankBalance);
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
    
    
    
}
