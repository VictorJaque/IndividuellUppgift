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
public class Wallet extends MoneyValue {  //Klass som symboliserar en plånbok
    //Attribut 
    private static ArrayList<Money> wallet; //En arraylist av mina pengar
    private final Scanner scan; //Scanner som kan användas vid uttag och insättning
    private static int walletBalance; //integer som visar hur mycket pengar man har i plånboken
    public static int bankBalance; //integer som visar hur mycket pengar man har i automaten
    
    
    //Konstruktor för en tom plånbok
    public Wallet(int value) {
        super(value);
        wallet = new ArrayList<>();
        scan = new Scanner(System.in);
        walletBalance = 0;
        bankBalance = 0;
    }
    
    
    //Metod för att fylla plånboken med alla valörer. Använder sig av metoder från Money Klassen.
    public void fillWallet(int amt) {
        Money ones = new Money(1 * amt);
        getWallet().add(ones);
        Money fives = new Money(5 * amt);
        getWallet().add(fives);
        Money tens = new Money(10 * amt);
        getWallet().add(tens);
        Money twentys = new Money(20 * amt);
        getWallet().add(twentys);
        Money fiftys = new Money(50 * amt);
        getWallet().add(fiftys);
        Money hundreds = new Money(100 * amt);
        getWallet().add(hundreds);
        setValue(0);
        getWallet().forEach((Money i) -> { //forEach loop för att uppdatera walletBalance
            setValue(getValue() + (i.getValue() * i.getAmt()));
            setWalletBalance(getWalletBalance() + i.getValue());
        });
    }
    
    //Metod för att sätta in pengar på bankBalance
    public void depositBank() throws InterruptedException {  //Funktion för sätta in pengar på sitt konto
        boolean waitForInp = true; //boolean som är true tills användaren väljer ett alternativ som avslutar menyn

        //While-loop som producerar text till användaren är klar med sin instättning
        while(waitForInp) {
            Menu.clearScreen(); 
            Menu.depositBankText();
            int input = scan.nextInt();   //Skannar efter belopp att sätta in
            if (input == 0) { //Om inmatningen är 0 ska programmet avslutas
                boolean amSure = Menu.areYouSure(); //Validerar så användaren är säker
                if (amSure) {
                    waitForInp = false;
                }
            } else if (input > getWalletBalance()) { //Om inmatningen är större än beloppet man har i plånboken så får man felmeddelande
                Menu.tryAgainTxt();
            } else {
                boolean amSure;
                amSure = Menu.areYouSure(); //validerar så användaren är säker
                if (amSure) { //om säker
                    int tempWallet = input; //beloppet hamnar i en temporär variabel
                    while (tempWallet > 0) { //så länge den temporära plånboken inte är 0 så ska den sätta in efter varje valör
                        while (tempWallet >= 100) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 100);       
                            setWalletBalance(getWalletBalance() - 100);
                            tempWallet -= 100;
                            wallet.get(5).setAmt(wallet.get(5).getAmt() - 1);
                            Menu.depositText(100);
                        }
                        while (tempWallet >= 50 && tempWallet <= 99) {  // så länge beloppet är högre än 50 och mindre än 100 ska 50-kr sedlar in
                            setBankBalance(getBankBalance() + 50);       
                            setWalletBalance(getWalletBalance() - 50);
                            tempWallet -= 50;
                            wallet.get(4).setAmt(wallet.get(4).getAmt() - 1);
                            Menu.depositText(50);
                        } 
                        while (tempWallet >= 20 && tempWallet <= 49) {  // så länge beloppet är högre än 20 och mindre än 50 ska 20-kr sedlar in
                            setBankBalance(getBankBalance() + 20);       
                            setWalletBalance(getWalletBalance() - 20);
                            tempWallet -= 20;
                            wallet.get(3).setAmt(wallet.get(3).getAmt() - 1);
                            Menu.depositText(20);
                        } 
                        while (tempWallet >= 10 && tempWallet <=19) {  // så länge beloppet är högre än 10 och mindre än 20 ska 10kr mynt in
                            setBankBalance(getBankBalance() + 10);       
                            setWalletBalance(getWalletBalance() - 10);
                            tempWallet -= 10;
                            wallet.get(2).setAmt(wallet.get(2).getAmt() - 1);
                            Menu.depositText(10);
                        }
                        while (tempWallet >= 5 && tempWallet <= 9) {  // så länge beloppet är högre än 5 och mindre än 10 ska 5kr mynt in
                            setBankBalance(getBankBalance() + 5);       
                            setWalletBalance(getWalletBalance() - 5);
                            tempWallet -= 5;
                            wallet.get(1).setAmt(wallet.get(1).getAmt() - 1);
                            Menu.depositText(5);
                        }
                        while (tempWallet >= 1 && tempWallet <=4) {  // så länge beloppet är högre än 1 och mindre än 5 ska 1kr mynt in
                            setBankBalance(getBankBalance() + 1);       
                            setWalletBalance(getWalletBalance() - 1);
                            tempWallet -= 1;
                            wallet.get(0).setAmt(wallet.get(0).getAmt() - 1);
                            Menu.depositText(1);
                        }
                    }
                }
                TimeUnit.SECONDS.sleep(1); //stannar upp konsolen i 1 sekund
                Menu.successTxt();   // funktion som visar att allt är klart 
            }
            waitForInp = false; //stänger ner menyn
        }
    }
    
    //Omvänd logik från depositBank()
    public void withdrawalBank() throws InterruptedException { 
        boolean waitForInp = true; 

        while(waitForInp) {
            Menu.clearScreen();
            Menu.withdrawalBankText();
            int input = scan.nextInt();   //Skannar efter belopp
            if (input == 0) {
                boolean amSure = Menu.areYouSure();
                if (amSure) {
                    waitForInp = false;
                }
            } else if (input > getWalletBalance()) {
                Menu.tryAgainTxt();
            } else {
                boolean amSure;
                amSure = Menu.areYouSure();
                if (amSure) {
                    int tempWallet = input;
                    while (tempWallet > 0) {
                        while (tempWallet >= 100) {
                            setBankBalance(getBankBalance() - 100);       
                            setWalletBalance(getWalletBalance() + 100);
                            tempWallet -= 100;
                            wallet.get(5).setAmt(wallet.get(5).getAmt() + 1);
                            Menu.withdrawalText(100);
                        } 
                        while (tempWallet >= 50 && tempWallet <= 99) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() - 50);       
                            setWalletBalance(getWalletBalance() + 50);
                            tempWallet -= 50;
                            wallet.get(4).setAmt(wallet.get(4).getAmt() + 1);
                            Menu.withdrawalText(50);
                        } 
                        while (tempWallet >= 20 && tempWallet <= 49) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() - 20);       
                            setWalletBalance(getWalletBalance() + 20);
                            tempWallet -= 20;
                            wallet.get(3).setAmt(wallet.get(3).getAmt() + 1);
                            Menu.withdrawalText(20);

                        } 
                        while (tempWallet >= 10 && tempWallet <=19) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() - 10);       
                            setWalletBalance(getWalletBalance() + 10);
                            tempWallet -= 10;
                            wallet.get(2).setAmt(wallet.get(2).getAmt() + 1);
                            Menu.withdrawalText(10);
                        }
                        while (tempWallet >= 5 && tempWallet <= 9) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() - 5);       
                            setWalletBalance(getWalletBalance() + 5);
                            tempWallet -= 5;
                            wallet.get(1).setAmt(wallet.get(1).getAmt() + 1);
                            Menu.withdrawalText(5);
                        }
                        while (tempWallet >= 1 && tempWallet <=4) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() - 1);       
                            setWalletBalance(getWalletBalance() + 1);
                            tempWallet -= 1;
                            wallet.get(0).setAmt(wallet.get(0).getAmt() + 1);
                            Menu.withdrawalText(1);
                        }
                    }
                }
                Menu.successTxt();   // funktion som visar att allt är klart 
            }
            waitForInp = false; // Stänger ner menyn
        }
    }

    //Metod för att ta ut resterande pengar som finns på bankbalance vid avslut av menyn.
    public void withdrawalBankExit() throws InterruptedException {        
        //Logiken är likadan som withdrawalBank() bara att den inte låter användaren själv mata in hur mycket som ska tas ut 
        //utan den gör det automatiskt 
        int balanceBefore = getBankBalance();
        while (getBankBalance() > 0) {
            while (bankBalance >= 100) {
                setBankBalance(getBankBalance() - 100);       
                setWalletBalance(getWalletBalance() + 100);
                Menu.withdrawalText(100);
            } 
            TimeUnit.SECONDS.sleep(1);
            while (bankBalance >= 50 && bankBalance <= 99) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                setBankBalance(getBankBalance() - 50);       
                setWalletBalance(getWalletBalance() + 50);
                Menu.withdrawalText(50);
            } 
            TimeUnit.SECONDS.sleep(1);
            while (bankBalance >= 20 && bankBalance <= 49) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                setBankBalance(getBankBalance() - 20);       
                setWalletBalance(getWalletBalance() + 20);
                Menu.withdrawalText(20);
            } 
            TimeUnit.SECONDS.sleep(1);
            while (bankBalance >= 10 && bankBalance <=19) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                setBankBalance(getBankBalance() - 10);       
                setWalletBalance(getWalletBalance() + 10);
                Menu.withdrawalText(10);
            }
            TimeUnit.SECONDS.sleep(1);
            while (bankBalance >= 5 && bankBalance <= 9) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                setBankBalance(getBankBalance() - 5);       
                setWalletBalance(getWalletBalance() + 5);
                Menu.withdrawalText(5);
            }
            TimeUnit.SECONDS.sleep(1);
            while (bankBalance >= 1 && bankBalance <=4) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                setBankBalance(getBankBalance() - 1);       
                setWalletBalance(getWalletBalance() + 1);
                Menu.withdrawalText(1);
            }
            TimeUnit.SECONDS.sleep(1);
        }    
        //Avslutningsmeddelande som säger hur mycket man tagit ut och hur mycket man har kvar i sin plånbok
        Menu.clearScreen();
        Menu.produceLine();
        Menu.produceRow(" ");
        Menu.produceRow("You have now withdrawn " + balanceBefore + " SEK to your wallet  ");
        Menu.produceRow(" ");
        Menu.produceRow("Your wallet now has: " + walletBalance + " SEK");
        Menu.produceRow("See you next time and enjoy your new products");
        Menu.produceRow(" ");
        Menu.produceLine();
    
                    
                
            
        
    }
    
    
    //Menysida för att kolla sitt saldo på banken
    public void checkBalance() {
        Menu.checkBalanceTxt(getBankBalance());
        boolean waitForInp = true;
        int menuChoice = scan.nextInt();
        while (waitForInp) { //Håller igång menyn tills man trycker 0
            int exit = menuChoice;        
            if (exit == 0) {
            waitForInp = false; //går tillbaka i menyn
            }
        }
    }

    /**
     * @return the wallet
     */
    public ArrayList<Money> getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(ArrayList<Money> wallet) {
        this.wallet = wallet;
    }

    /**
     * @return the value
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * @param aValue the value to set
     */
    @Override
    public void setValue(int aValue) {
        value = aValue;
    } 
    
    static int getWalletBalance() {
        return walletBalance;
    }
    
    public static int getBankBalance() {
        return bankBalance;
    }

    /**
     * @param aWalletBalance the walletBalance to set
     */
    public static void setWalletBalance(int aWalletBalance) {
        walletBalance = aWalletBalance;
    }

    /**
     * @param aBankBalance the bankBalance to set
     */
    public static void setBankBalance(int aBankBalance) {
        bankBalance = aBankBalance;
    }
}
