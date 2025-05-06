import Accounts.CreditAccount;
import Accounts.DebitAccount;
import Accounts.DepositeAccount;
import Banks.Bank;
import Banks.CentralBank;
import Entities.Client;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to create central bank? (Y/N)");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("Y")) {
                break;
            }
            CentralBank centralBank = new CentralBank();

            System.out.println("Do you want to create a bank? (Y/N)");
            ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("Y")) {
                break;
            }

            System.out.println("Enter the name of the bank");
            String name = scanner.nextLine();
            System.out.println("Enter the interest rate of the bank");
            double interestRate = scanner.nextDouble();
            System.out.println("Enter the credit limit of the bank");
            double creditLimit = scanner.nextDouble();
            System.out.println("Enter the commission of the bank");
            double commission = scanner.nextDouble();

            Bank bank = centralBank.CreateBank(name, interestRate, creditLimit, commission);

            System.out.println("Do you want to create a client? (Y/N)");
            ans = scanner.next();
            if (!ans.equalsIgnoreCase("Y")) {
                break;
            }

            System.out.println("Enter the first name of the client");
            String firstName = scanner.next();
            System.out.println("Enter the last name of the client");
            String lastName = scanner.next();
            Client client = new Client(firstName, lastName);

            System.out.println("Do you want to create an account? (Y/N)");
            ans = scanner.next();
            if (ans.equalsIgnoreCase("Y")) {
                System.out.println("What type of account do you want to create (c - credit, d - debit, dd - deposit)");
                ans = scanner.next();
                if (ans.equalsIgnoreCase("c")) {
                    CreditAccount account = bank.createCreditAccount(client);


                } else if (ans.equalsIgnoreCase("d")) {
                    DebitAccount account = bank.createDebitAccount(client);
                } else if (ans.equalsIgnoreCase("dd")) {
                    System.out.println("Enter the amount you want to deposit");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter the period");
                    int period = scanner.nextInt();
                    DepositeAccount account = bank.createDepositAccount(client, amount, period);
                }

            }

        }

        scanner.close();
        CentralBank centralBank = new CentralBank();
        Bank bank = centralBank.CreateBank("LeshaBank", 23, 23, 23);
        // создаем клиента
        Client client = new Client("Lesha", "Vashenkov");
        Client client2 = new Client("Lesha", "Vashenkov");
        // создаем счет
        DebitAccount debitAccount =  bank.createDebitAccount(client);
        DebitAccount debitAccount2 =  bank.createDebitAccount(client2);
        System.out.println(debitAccount.getBalance());
        debitAccount.deposit(45);
        debitAccount.interestCalculation();
        bank.interestPayment();
        System.out.println(debitAccount.getBalance());
        centralBank.NoticeForCommission();
        debitAccount.sendMoney(debitAccount2.id, 40);
        debitAccount.Cancelling();
        System.out.println(debitAccount.getBalance());
        }

    }