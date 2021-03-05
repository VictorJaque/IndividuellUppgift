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



    
    private final Scanner scan;
    private static int walletBalance;
    static int bankBalance;
    
    
    //Konstruktor för en tom plånbok
    public Wallet(int value) {
        super(value);
        wallet = new ArrayList<>();
        scan = new Scanner(System.in);
        walletBalance = 0;
        bankBalance = 0;
    }
    
    
    //Metod för att fylla plånboken med alla valörer. Använder sig av metoder från Moneys Klassen.
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
        getWallet().forEach((Money i) -> {
            setValue(getValue() + (i.getValue() * i.getAmt()));
            setWalletBalance(getWalletBalance() + i.getValue());
        });
    } //Klar, Bara kommentera
    
    public void depositBank() throws InterruptedException {  //Funktion för sätta in pengar på sitt konto
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

        while(waitForInp) {
            Menu.clearScreen();
            Menu.depositBankText();
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
                            setBankBalance(getBankBalance() + 100);       
                            setWalletBalance(getWalletBalance() - 100);
                            tempWallet -= 100;
                            wallet.get(5).setAmt(wallet.get(5).getAmt() - 1);
                            Menu.depositText(100);
                        }
                        while (tempWallet >= 50 && tempWallet <= 99) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 50);       
                            setWalletBalance(getWalletBalance() - 50);
                            tempWallet -= 50;
                            wallet.get(4).setAmt(wallet.get(4).getAmt() - 1);
                            Menu.depositText(50);
                        } 
                        while (tempWallet >= 20 && tempWallet <= 49) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 20);       
                            setWalletBalance(getWalletBalance() - 20);
                            tempWallet -= 20;
                            wallet.get(3).setAmt(wallet.get(3).getAmt() - 1);
                            Menu.depositText(20);
                        } 
                        while (tempWallet >= 10 && tempWallet <=19) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 10);       
                            setWalletBalance(getWalletBalance() - 10);
                            tempWallet -= 10;
                            wallet.get(2).setAmt(wallet.get(2).getAmt() - 1);
                            Menu.depositText(10);
                        }
                        while (tempWallet >= 5 && tempWallet <= 9) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 5);       
                            setWalletBalance(getWalletBalance() - 5);
                            tempWallet -= 5;
                            wallet.get(1).setAmt(wallet.get(1).getAmt() - 1);
                            Menu.depositText(5);
                        }
                        while (tempWallet >= 1 && tempWallet <=4) {  // så länge beloppet är högre än 100 ska 100-kr sedlar in
                            setBankBalance(getBankBalance() + 1);       
                            setWalletBalance(getWalletBalance() - 1);
                            tempWallet -= 1;
                            wallet.get(0).setAmt(wallet.get(0).getAmt() - 1);
                            Menu.depositText(1);
                        }
                    }
                }
            }
            TimeUnit.SECONDS.sleep(1);
            Menu.successTxt();   // funktion som visar att allt är klart 
            waitForInp = false;
        }
    }
    
    
    public void withdrawalBank() throws InterruptedException { //Meny för att ta ut pengar.  Logiken är likadan som för att ta ut, vissa ändringar för att optimera samt ändrat på operatorer för att minska istället för att öka och tvärtom
        boolean waitForInp = true; //Samma logik med att producera text som tidigare

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
            }
            Menu.successTxt();   // funktion som visar att allt är klart 
            waitForInp = false;
        }
    }
    
        
    
    
    public void withdrawalBankExit() throws InterruptedException {        //GÖR OM
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
    
    public void checkBalance() {
        Menu.checkBalanceTxt(getBankBalance());
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
