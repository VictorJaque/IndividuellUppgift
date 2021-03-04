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
public class Wallet extends Moneys {  //Klass som symboliserar en plånbok
    //Attribut
    private ArrayList<Moneys> wallet; //En arraylist av mina pengar
    static int walletBalance; //Ett saldo i int som baseras efter hur mycket pengar som finns i plånboken
    private Scanner scan;
    
    
    //Konstruktor för en tom plånbok
    public Wallet() {
        super(0, 0);
        wallet = new ArrayList<>();
        walletBalance = 0;
        scan = new Scanner(System.in);
    }
    
    
    //Metod för att fylla plånboken med alla valörer. Använder sig av metoder från Moneys Klassen.
    public void fillWallet(int amt) {
        Moneys ones = new Moneys(1, amt);
        this.getWallet().add(ones);
        Moneys fives = new Moneys(5, amt);
        this.getWallet().add(fives);
        Moneys tens = new Moneys(10, amt);
        this.getWallet().add(tens);
        Moneys twentys = new Moneys(20, amt);
        this.getWallet().add(twentys);
        Moneys fiftys = new Moneys(50, amt);
        this.getWallet().add(fiftys);
        Moneys hundreds = new Moneys(100, amt);
        this.getWallet().add(hundreds);
        setWalletBalance(0);
        this.getWallet().forEach((Moneys i) -> {
            setWalletBalance(getWalletBalance() + (i.value * i.getAmt()));
        });
    } //Klar, Bara kommentera
    
    public void depositBank() throws InterruptedException {  //Funktion för sätta in pengar på sitt konto
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            Menu.depositBankText();
            int amt = getScan().nextInt();   //Skannar efter belopp
            boolean isSure = Menu.areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.getWalletBalance()) < amt) {
                    Menu.tryAgainTxt();  //om man har för lite pengar i plånboken får man ett error meddelande
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) { //while loop som säger att så länge det finns pengar kvar att sätta in så ska den fortsätta
                        if (tempWallet >= 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 100) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 100);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 50 && tempWallet < 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 50) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 50);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            } 
                        } else if (tempWallet >= 20 && tempWallet < 50) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 20) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 20);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            } 
                        } else if (tempWallet >= 10 && tempWallet < 20) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 10) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 10);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 5) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 5);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 1 && tempWallet < 5) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 1) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() - 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() + 1);  
                                    setWalletBalance(getWalletBalance() - i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        }
                        
                    }
                Menu.successTxt();   // funktion som visar att allt är klart 
                waitForInp = false; //Stänger ner menyn
                }
            }
        }
    }
    
    public void withdrawalBank() throws InterruptedException { //Meny för att ta ut pengar.  Logiken är likadan som för att ta ut, vissa ändringar för att optimera samt ändrat på operatorer för att minska istället för att öka och tvärtom
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            Menu.withdrawalBankText();
            int amt = getScan().nextInt();   //Skannar efter belopp
            boolean isSure = Menu.areYouSure();         //Validering för användaren 
            if (amt == 0) {  //if statement som avbryter om använder matar in 0
                waitForInp = false;
            } else if (isSure) { //else if statement för att sätta in pengar 
                if ((this.getWalletBalance()) < amt) {
                    Menu.tryAgainTxt();  //om man har för lite pengar i plånboken får man ett error meddelande
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) { //while loop som säger att så länge det finns pengar kvar att sätta in så ska den fortsätta
                        if (tempWallet >= 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 100) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 100);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 50 && tempWallet < 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 50) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 50);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            } 
                        } else if (tempWallet >= 20 && tempWallet < 50) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 20) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 20);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            } 
                        } else if (tempWallet >= 10 && tempWallet < 20) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 10) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 10);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 5) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 5);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        } else if (tempWallet >= 1 && tempWallet < 5) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            for (Moneys i: getWallet()) {  // for each loop för att kolla igenom listan med pengar
                                if (i.value == 1) {  // ser till att det är en 100-kr sedel som går in
                                    i.setAmt(i.getAmt() + 1); // ändrar antalet i plånboken
                                    Menu.setBankBalance(Menu.getBankBalance() - 1);  
                                    setWalletBalance(getWalletBalance() + i.value);
                                    tempWallet -= i.value;
                                    Menu.depositText(i);
                                    TimeUnit.SECONDS.sleep(1);  //Stannar upp konsolen i 1 sekund så att användaren hinner se
                                }                 
                            }
                        }
                        
                    }
                Menu.successTxt();   // funktion som visar att allt är klart 
                waitForInp = false; //Stänger ner menyn
                }
            }
        }
    }
    
    public void checkBalance() {
        Menu.checkBalanceTxt(walletBalance);
        boolean waitForInp = true;
        int menuChoice = scan.nextInt();
        while (waitForInp) {
            int exit = menuChoice;        
            if (exit == 0) {
            waitForInp = false;
            }
        }
    }

    /**
     * @return the wallet
     */
    public ArrayList<Moneys> getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(ArrayList<Moneys> wallet) {
        this.wallet = wallet;
    }

    /**
     * @return the walletBalance
     */
    public int getWalletBalance() {
        return walletBalance;
    }

    /**
     * @param walletBalance the walletBalance to set
     */
    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    /**
     * @return the scan
     */
    public Scanner getScan() {
        return scan;
    }

    /**
     * @param scan the scan to set
     */
    public void setScan(Scanner scan) {
        this.scan = scan;
    }
    
    
    
}
