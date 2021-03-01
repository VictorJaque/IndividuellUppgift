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
public class Menu {
    //Attribut
    public int bankBalance;
    public ArrayList<Moneys> wallet;
    public int walletBalance;
    
    
    //konstruktor
    public Menu() {
        wallet = new ArrayList<>();
        walletBalance = 0;
        bankBalance = 0;
        
    }
    
    public void startMenu() {       
        boolean startMenu = true;
        Scanner scan = new Scanner(System.in);
        while (startMenu) {
            for (int i = 0; i < 50; ++i) {System.out.println();}
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
            switch(menuChoice) {
                case 0:
                    boolean areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        startMenu = false;  
                        break;
                    }
                case 1:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        openBank();
                        break;
                    }
                case 2:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        openShop();
                        break;
                    }
                    
                default: System.out.println("Enter a valid number");
                }
            }  
        } //Klar?
    
    public void openBank() {
        boolean waitForInp = true;
        while(waitForInp) {
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
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
                        //Kalla funktion
                        waitForInp = false;  
                        }
                        break;
                case 1:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        depositBank();
                    }
                    break;
                case 2:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        withdrawalBank();
                    }
                    break;
                case 3:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        checkBalance();
                    }
                    break;
                default: System.out.println("Enter a valid number");
                }
            }
        startMenu();
    }  //Klar?
    
    public void openShop() {
       boolean waitForInp = true;
        while(waitForInp) {
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                      Welcome to vicJaq1337s next level e-store                     |");
            System.out.println("|                                                                                    |");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |");
            System.out.println("|                        Select one of the following choices:                        |");

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
                        //Kalla funktion
                        waitForInp = false;  
                        }
                        break;
                case 1:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        depositBank();
                    }
                    break;
                case 2:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        withdrawalBank();
                    }
                    break;
                case 3:
                    areYouSure = areYouSure();
                    if (areYouSure) {
                        //Kalla funktion
                        checkBalance();
                    }
                    break;
                default: System.out.println("Enter a valid number");
                }
            }
        startMenu();
    }  //Klar?
    }


    public void depositBank() {
        boolean waitForInp = true;

        while(waitForInp) { 
            for (int i = 0; i < 50; ++i) {System.out.println();}
            System.out.println("|------------------------------------------------------------------------------------|");
            System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
            System.out.println("|                         Bank of vicJaq1337s next level e-store                     |");
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
            Scanner scan = new Scanner(System.in);
            int amt = scan.nextInt();
            boolean isSure = areYouSure();          
            if (amt == 0) {
                waitForInp = false;
            } else if (isSure) {
                if ((this.walletBalance) < amt) {
                    tryAgainTxt();
                    amt;
                } else { 
                    int tempWallet = amt;
                    while (tempWallet > 0) {
                        if (tempWallet >= 100) {
                        for (Moneys i: wallet) {
                            if (i.value == 100) {
                                i.amt -= 1;
                                tempWallet -= 100;
                                this.bankBalance += 100;
                            }                 
                        }
                        } else if (tempWallet >= 50 && tempWallet < 100) {
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt -= 1;
                                    tempWallet -= 50;
                                    this.bankBalance += 50;
                                }                 
                            }
                        } else if (tempWallet >= 20 && tempWallet < 50) {
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt -= 1;
                                    tempWallet -= 20;
                                    this.bankBalance += 20;
                                }
                            }
                        } else if (tempWallet >= 10 && tempWallet < 20) {
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt -= 1;
                                    tempWallet -= 10;
                                    this.bankBalance += 10;
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    tempWallet -= 5;
                                    this.bankBalance += 5;
                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt -= 1;
                                    tempWallet -= 1; 
                                    this.bankBalance += 1;
                                }
                            }
                        }
                        
                        
                    }
                successTxt();   
                walletBalance = 0;
                wallet.forEach((Moneys i) -> {
                walletBalance += (i.value * i.amt);
                        });
                waitForInp = false;
                    
                }
            }
        }
        
        openBank();
    }// Klar

    public void withdrawalBank() {
        boolean waitForInp = true;
        Scanner scan = new Scanner(System.in);
        withdrawalBankTxt();        
        while(waitForInp) { 
            int amt = scan.nextInt();
            if (amt > this.bankBalance) {
                tryAgainTxt();
                withdrawalBankTxt();
                amt;
            }
            boolean isSure = areYouSure();          
            if (amt == 0) {
                waitForInp = false;
            } else if (isSure) {
                int tempWallet = amt;
                while (tempWallet > 0) {
                        if (tempWallet >= 100) {
                        for (Moneys i: wallet) {
                            if (i.value == 100) {
                                i.amt -= 1;
                                tempWallet -= 100;
                            }                 
                        }
                        } else if (tempWallet >= 50 && tempWallet < 100) {
                            for (Moneys i: wallet) {
                                if (i.value == 50) {
                                    i.amt -= 1;
                                    tempWallet -= 50; 
                                }                 
                            }
                        } else if (tempWallet >= 20 && tempWallet < 50) {
                            for (Moneys i: wallet) {
                                if (i.value == 20) {
                                    i.amt -= 1;
                                    tempWallet -= 20;
                                }
                            }
                        } else if (tempWallet >= 10 && tempWallet < 20) {
                            for (Moneys i: wallet) {
                                if (i.value == 10) {
                                    i.amt -= 1;
                                    tempWallet -= 10;
                                }                  
                            }
                        } else if (tempWallet >= 5 && tempWallet < 10) {
                            for (Moneys i: wallet) {
                                if (i.value == 5) {
                                    i.amt -= 1;
                                    tempWallet -= 5;
                                }
                            
                            }
                        } else if (tempWallet >=1 && tempWallet <5) {
                            for (Moneys i: wallet) {
                                if (i.value == 1) {
                                    i.amt -= 1;
                                    tempWallet -= 1; 
                                }
                            }
                        }
                        
                
                    
                    this.bankBalance -= amt;
                    successTxt();
                    waitForInp = false;}
                } 
            }
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
    
    public static void bankTxt() {
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
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
    }  //Klar
    
        
    
    public static void depositBankTxt() {
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
        System.out.println("|                         Bank of vicJaq1337s next level e-store                     |");
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

    public static void successTxt() {
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

    public static void withdrawalBankTxt() {
        for (int i = 0; i < 50; ++i) {System.out.println();}
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |"); //21 tabs 1 mellanslag
        System.out.println("|                         Bank of vicJaq1337s next level e-store                     |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                    |");
        System.out.println("|                       So you want to take some of your money out?                  |");
        System.out.println("|        Please enter the amount you would like to withdraw from your balance        |");
        System.out.println("|                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                 Press 0 to go back                                 |");
        System.out.println("|------------------------------------------------------------------------------------|");
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

    public static void tryAgainTxt() {
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
    
}

    






    
    















}







//Meny switch/case copy
/*    Scanner scan = new Scanner(System.in);
    int menuChoice = scan.nextInt();
    boolean waitForInp = true;
    System.in(inp.nextInt());
    while(waitForInp) {
        switch(inp) {
            case 0:
                
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default: 
        }
    } */